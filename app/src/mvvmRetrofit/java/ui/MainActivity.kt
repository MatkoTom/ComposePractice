package com.example.composepractice.ui

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composepractice.R
import com.example.composepractice.ui.theme.ComposePracticeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                val viewModel = hiltViewModel<MainViewModel>()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GuessTheFlagName(viewModel)
                }
            }
        }
    }
}

@Composable
fun GuessTheFlagName(viewModel: MainViewModel) {
    val flag by viewModel.flag.collectAsState()
    val activity = (LocalContext.current as Activity)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(R.string.guess_the_flag),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        flag?.flagImage?.let {
            FlagItem(
                flagIcon = it,
                isGuessWrong = viewModel.isGuessWrong,
                userGuess = viewModel.guess,
                onGuessChanged = { guess -> viewModel.updateGuess(guess) },
                onKeyboardDone = { viewModel.checkFlagGuess() })
        }

        Button(onClick = { viewModel.checkFlagGuess() }, modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(R.string.submit))
        }

        Button(onClick = {
            Toast.makeText(
                activity,
                activity.getString(R.string.flag_name_was, viewModel.currentFlag.second),
                Toast.LENGTH_SHORT
            ).show()
            viewModel.skipFlagGuess()
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(R.string.skip))
        }
    }

    if (viewModel.isGameOver) {
        GameOverDialog(modifier = Modifier, onPlayAgain = { viewModel.resetGame() })
    }
}

@Composable
fun GameOverDialog(modifier: Modifier, onPlayAgain: () -> Unit) {
    val activity = (LocalContext.current as Activity)

    AlertDialog(
        onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onDismissRequest.
        },
        title = { Text(stringResource(R.string.game_over)) },
        text = { Text(stringResource(R.string.the_game_is_now_finished)) },
        modifier = modifier,
        dismissButton = {
            TextButton(
                onClick = {
                    activity.finish()
                }
            ) {
                Text(text = stringResource(R.string.exit))
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onPlayAgain()
                }
            ) {
                Text(text = stringResource(R.string.play_again))
            }
        }
    )

}

@Composable
fun FlagItem(
    flagIcon: Bitmap,
    isGuessWrong: Boolean,
    userGuess: String,
    onGuessChanged: (String) -> Unit,
    onKeyboardDone: () -> Unit
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.country_name_question))

            Image(
                painter = BitmapPainter(flagIcon.asImageBitmap()),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
            )

            OutlinedTextField(
                value = userGuess,
                isError = isGuessWrong,
                onValueChange = onGuessChanged,
                singleLine = true,
                label = {
                    if (isGuessWrong) {
                        Text(text = stringResource(R.string.you_guessed_wrong))
                    } else {
                        Text(
                            text = stringResource(R.string.enter_your_guess)
                        )
                    }
                },
                keyboardActions = KeyboardActions(
                    onDone = { onKeyboardDone() }
                )
            )
        }
    }
}
