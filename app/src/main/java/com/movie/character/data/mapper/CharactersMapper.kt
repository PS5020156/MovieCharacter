package com.movie.character.data.mapper

import com.movie.character.data.dto.CharactersDto
import com.movie.character.domain.model.Characters

fun CharactersDto.toDomainCharacter() : Characters {
    return Characters(actor, id, image, name)
}