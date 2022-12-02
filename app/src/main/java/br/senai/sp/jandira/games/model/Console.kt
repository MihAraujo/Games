package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_console")
class Console {

    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "console_name")
    var nome = ""

    @ColumnInfo(name = "console_fabricante")
    var fabricante = ""

    @ColumnInfo(name = "console_descricao")
    var descricao = ""

//    @ColumnInfo(name = "console_foto")
//    var consoleImgame: Bitmap? = null

    @ColumnInfo(name = "console_ano_lancamento")
    var anoLancamento = 0
}