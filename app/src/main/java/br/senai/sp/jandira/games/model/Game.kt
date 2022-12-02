package br.senai.sp.jandira.games.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Private int codigo

@Entity(tableName = "tbl_game")
class Game {

    @PrimaryKey(autoGenerate = true)
    var codigo = 0

    @ColumnInfo(name = "enterprise_name")
    var nomeEnterprise = ""

    @ColumnInfo(name = "game_name")
    var nomeGame = ""

    @ColumnInfo(name = "descricao_name")
    var descricao = ""

    @ColumnInfo(name = "game_release_date")
    var gameReleaseGame = ""

    @ColumnInfo(name = "game_status")
    var gameStatus = ""

    @ColumnInfo(name = "game_image")
    var gameImage: ByteArray? = null

    var userId = 0
}