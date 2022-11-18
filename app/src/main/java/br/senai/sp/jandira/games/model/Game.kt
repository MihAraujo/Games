package br.senai.sp.jandira.games.model

import android.graphics.drawable.Drawable
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

//    var imagem: Drawable? = null
}