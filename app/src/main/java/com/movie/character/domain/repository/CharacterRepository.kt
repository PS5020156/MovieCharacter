package com.movie.character.domain.repository

import com.movie.character.core.common.Resource
import com.movie.character.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getAllCharacters() : Flow<Resource<List<Characters>>>
}