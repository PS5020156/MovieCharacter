package com.movie.character.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.movie.character.presentation.state.CharactersState

@Composable
fun CharacterScreen(modifier: Modifier, charactersState: CharactersState) {

    if (charactersState.isLoading) {
        Box(modifier = modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
        }
    } else if (!charactersState.errorMsg.isNullOrEmpty()) {
        Box(modifier = modifier.fillMaxSize()) {
            Text(text = charactersState.errorMsg.toString(), modifier = modifier.align(Alignment.Center))
        }
    }

    if (charactersState.characters?.isNotEmpty()!!) {
        LazyColumn {
            items(charactersState.characters) {
                CharacterItem(modifier = modifier, character = it)
            }
        }
    }

}