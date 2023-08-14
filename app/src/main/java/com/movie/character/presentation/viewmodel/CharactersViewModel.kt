package com.movie.character.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.character.core.common.Resource
import com.movie.character.domain.usecase.GetAllCharacterUseCase
import com.movie.character.presentation.state.CharactersState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val useCase: GetAllCharacterUseCase) :
    ViewModel() {

    private val _charactersState = MutableStateFlow(CharactersState())
    val charactersState: StateFlow<CharactersState>
        get() = _charactersState

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        useCase().onEach {
            when (it) {
                is Resource.Error -> {
                    _charactersState.value = CharactersState().copy(errorMsg = it.msg)
                }
                is Resource.Loading -> {
                    _charactersState.value = CharactersState().copy(isLoading = true)
                }
                is Resource.Success -> {
                    _charactersState.value = CharactersState().copy(characters = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}