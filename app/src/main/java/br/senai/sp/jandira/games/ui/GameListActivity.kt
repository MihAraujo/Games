package br.senai.sp.jandira.games.ui

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.adapter.GamesAdapter
import br.senai.sp.jandira.games.dao.game.GameDao
import br.senai.sp.jandira.games.databinding.ActivityGameListBinding
import br.senai.sp.jandira.games.model.Usuario
import br.senai.sp.jandira.games.repository.ConsoleRepository
import br.senai.sp.jandira.games.repository.UsuarioRepository
import br.senai.sp.jandira.games.utils.getBitmapFromByteArray

class GameListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameListBinding
    lateinit var usuarioRepository: UsuarioRepository
    var usuario: Usuario? = null
    var userId = 0;

    lateinit var adapterGames: GamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        usuarioRepository = UsuarioRepository(this)
        createProfile()


        var rvGames = binding.rvGames
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapterGames = GamesAdapter(this)
        rvGames.adapter = adapterGames
        setGameAdapterData()

        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(this, R.color.blue_waves)
            )
        )
    }

    private fun createProfile() {
        userId = intent.getIntExtra("userId", 0)
        usuario = usuarioRepository.getUsuarioById(userId)

        binding.textNameGamelist.text = usuario?.nome
        binding.textEmailGamelist.text = usuario?.email
        binding.gamesTextViewLevel.text = usuario?.nivel.toString()
        binding.imageUser.setImageBitmap(getBitmapFromByteArray(usuario?.foto))

        val games = usuarioRepository.getUsuarioGame(userId)[0].games

        var counterFinished = 0;
        var counterPlaying = 0;

        games.forEach { game -> if(game.gameStatus[0].lowercase() == "f") {
            counterFinished++
        } else {
            counterPlaying++
        }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_game_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.title.toString() == "Add") {
            val openCreateGameActivity = Intent(this, )
        }
    }

    private fun setGameAdapterData() {
        val gameList = usuarioRepository.getUsuarioGame(userId)[0].games
        adapterGames.updateGameList(gameList)
    }

    override fun onResume() {
        super.onResume()
        setGameAdapterData()
    }
}