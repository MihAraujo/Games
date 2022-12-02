package br.senai.sp.jandira.games.dao.usuario

import androidx.room.*
import br.senai.sp.jandira.games.model.UserWithGame
import br.senai.sp.jandira.games.model.Usuario

@Dao
interface UsuarioDao {
    @Transaction
    @Query("SELECT * FROM tbl_usuario WHERE id =: id")
    fun getUserGame(id: Int): List<UserWithGame>

    @Insert
    fun save(usuario: Usuario): Long

    @Delete
    fun delete(usuario: Usuario): Int

    @Update
    fun update(usuario: Usuario): Int

    @Query("SELECT * FROM tbl_usuario ORDER BY usuario_nome ASC")
    fun getAll(): List<Usuario>

    @Query("SELECT * FROM tbl_usuario WHERE id=:id")
    fun getUsuarioById(id: Int): Usuario

    @Query("SELECT * FROM tbl_usuario WHERE usuario_email=:email")
    fun getUsuarioByEmail(email: String): Usuario
}