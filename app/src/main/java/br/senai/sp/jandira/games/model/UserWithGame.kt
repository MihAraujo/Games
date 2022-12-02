package br.senai.sp.jandira.games.model

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithGame (
    @Embedded val usuario: Usuario,
            @Relation(
                parentColumn = "id",
                entityColumn = "userId"
            )
            val games: List<Game>
)