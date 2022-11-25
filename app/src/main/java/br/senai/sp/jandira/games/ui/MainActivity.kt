package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.senai.sp.jandira.games.databinding.ActivityMainBinding
import br.senai.sp.jandira.games.model.Usuario
import br.senai.sp.jandira.games.repository.UsuarioRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var usuarioRepository: UsuarioRepository
    var usuario: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        usuarioRepository = UsuarioRepository(this)

        binding.textCreateAccount.setOnClickListener {
            val openSignUpActivity = Intent(this, SignUpActivity::class.java)
            startActivity(openSignUpActivity)
        }

        binding.buttonLogin.setOnClickListener{
            if (login()){
                val openGameListActivity = Intent(this, GameListActivity::class.java)
                startActivity(openGameListActivity)
            } else{
                Toast.makeText(this, "Autentificação é falha!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun login(): Boolean {
        if (validate()) {
            val emailText = binding.editTextEmailMain.text.toString()
            usuario = usuarioRepository.getUsuarioByEmail(emailText)

            if (usuario == null) {
                Toast.makeText(this, "Email não existe no DataBase!", Toast.LENGTH_SHORT).show()
                return false
            } else if (binding.editTextPasswordMain.text.toString() != usuario?.senha) {
                Toast.makeText(this, "Sua senha está errada!", Toast.LENGTH_SHORT).show()
                return false
            }
            return true
        }
        return false
    }

    private fun validate(): Boolean {
        if(binding.editTextEmailMain.text.isEmpty()) {
            binding.editTextEmailMain.error = "Email is required!"
            return false
        }else if(binding.editTextPasswordMain.text.isEmpty()) {
            binding.editTextPasswordMain.error = "Password is required!"
            return false
        }
        return true
    }
}