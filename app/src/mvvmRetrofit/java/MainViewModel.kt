package com.example.composepractice

import android.graphics.BitmapFactory
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composepractice.model.Flag
import com.example.composepractice.networking.RetrofitInstance
import com.example.composepractice.repository.MAX_COUNTRY_NUMBER
import com.example.composepractice.repository.getRandomCountry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val service = RetrofitInstance.service
    private lateinit var currentFlag: Pair<String, String>
    val flag: MutableStateFlow<Flag?> = MutableStateFlow(null)
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

        val response = service.getFlagByCountryCode(randomFlag.first)
        if (response.body() != null) {
            val imageData = response.body()?.bytes()
            val bitmap = imageData?.size?.let { BitmapFactory.decodeByteArray(imageData, 0, it) }

            flag.value = bitmap?.let { Flag(it) }
        } else
            flag.value = null
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
        getFlagRetrofit()
    }
}
