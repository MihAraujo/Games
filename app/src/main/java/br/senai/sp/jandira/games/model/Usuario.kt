package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_usuario")
class Usuario {

    @PrimaryKey(autoGenerate = true)
    var id = 0

//    @ColumnInfo(name = "usuario_foto")
//    var foto: Bitmap? = null

    @ColumnInfo(name = "usuario_email")
    var email = ""

    @ColumnInfo(name = "usuario_senha")
    var senha = ""

    @ColumnInfo(name = "usuario_nome")
    var nome = ""

    @ColumnInfo(name = "usuario_cidade")
    var cidade = ""

//    @ColumnInfo(name = "usuario_data_nascimento")
//    var dataNascimento: LocalDate? = null
//    var console: Console? = null

    @ColumnInfo(name = "usuario_niveis_enum")
    var nivel = NiveisEnum.INICIANTE

    @ColumnInfo(name = "usuario_sexo")
    var sexo: Char = 'd'
}