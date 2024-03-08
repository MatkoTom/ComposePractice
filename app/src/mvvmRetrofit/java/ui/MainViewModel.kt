package com.example.composepractice.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composepractice.model.Flag
import com.example.composepractice.repository.MAX_COUNTRY_NUMBER
import com.example.composepractice.repository.MainRepository
import com.example.composepractice.repository.getRandomCountry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    lateinit var currentFlag: Pair<String, String>

    private val _flag: MutableStateFlow<Flag?> = MutableStateFlow(null)
    val flag = _flag.asStateFlow()

    private val _score: MutableStateFlow<Int> = MutableStateFlow(0)
    val score = _score.asStateFlow()

    var guess by mutableStateOf("")
    var isGuessWrong by mutableStateOf(false)
    var isGameOver by mutableStateOf(false)
    private var usedCountriesList = mutableSetOf<Pair<String, String>>()

    init {
        resetGame()
    }

    private fun getFlagRetrofit() = viewModelScope.launch {
        val randomFlag = getRandomFlag()

        currentFlag = randomFlag
        usedCountriesList.add(randomFlag)

        _flag.value = repository.callFlagsApi(randomFlag)?.let { Flag(it) }
    }

    private fun getRandomFlag(): Pair<String, String> {
        val randomFlag = getRandomCountry()
        while (usedCountriesList.contains(randomFlag)) {
            return getRandomFlag()
        }
        return randomFlag
    }

    private fun updateGameState() {
        isGuessWrong = false
        updateGuess("")

        if (MAX_COUNTRY_NUMBER == usedCountriesList.size) {
            isGameOver = true
        } else {
            getFlagRetrofit()
        }
    }

    fun checkFlagGuess() {
        if (guess.equals(currentFlag.second, ignoreCase = true)) {
            updateGameState()
            _score.value++
        } else {
            updateGuess("")
            isGuessWrong = true
        }
    }

    fun skipFlagGuess() {
        updateGameState()
    }

    fun updateGuess(guessFlag: String) {
        guess = guessFlag
    }

    fun resetGame() {
        usedCountriesList.clear()
        isGameOver = false
        _score.value = 0
        getFlagRetrofit()
    }
}
