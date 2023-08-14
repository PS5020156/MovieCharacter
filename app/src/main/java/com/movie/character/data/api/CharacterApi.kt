package com.movie.character.data.api

import com.movie.character.data.dto.CharactersDto
import retrofit2.http.GET

interface CharacterApi {
    @GET("characters")
    suspend fun getAllCharacters() : List<CharactersDto>
}