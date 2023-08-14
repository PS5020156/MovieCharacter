package com.movie.character.presentation.state

import com.movie.character.domain.model.Characters

data class CharactersState(
    val characters: List<Characters> ? = emptyList(),
    val errorMsg: String? = "",
    val isLoading: Boolean = false
)
