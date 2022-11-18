package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.games.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.textCreateAccount.setOnClickListener {
            val openSignUpActivity = Intent(this, SignUpActivity::class.java)
            startActivity(openSignUpActivity)
        }

        binding.buttonLogin.setOnClickListener{
            val openGameListActivity = Intent(this, GameListActivity::class.java)
            startActivity(openGameListActivity)
        }
    }
}