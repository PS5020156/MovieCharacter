package com.movie.character.domain.usecase

import com.movie.character.domain.repository.CharacterRepository
import javax.inject.Inject

class GetAllCharacterUseCase @Inject constructor(private val repository: CharacterRepository) {
    operator fun invoke()  = repository.getAllCharacters()
}