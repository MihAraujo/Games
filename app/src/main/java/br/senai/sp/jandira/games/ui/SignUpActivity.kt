package br.senai.sp.jandira.games.ui

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivitySignUpBinding
import br.senai.sp.jandira.games.model.Console
import br.senai.sp.jandira.games.model.NiveisEnum
import br.senai.sp.jandira.games.model.Usuario
import br.senai.sp.jandira.games.repository.ConsoleRepository
import br.senai.sp.jandira.games.repository.UsuarioRepository
import br.senai.sp.jandira.games.utils.getBitmapFromUri
import br.senai.sp.jandira.games.utils.getByteArrayFromBitmap

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    lateinit var usuarioRepository: UsuarioRepository
    lateinit var usuario: Usuario
    private var id = 0
    private var photo: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuario = Usuario()
        id = intent.getIntExtra("id", 0)

        binding.slider.addOnChangeListener { slider, value, fromUsuario ->
            binding.editSliderLevel.text = getSliderText(binding.slider.value.toInt()).toString()
        }

        binding.imagePerson.setOnClickListener {
            getImageGallery()
        }

        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(this, R.color.blue_waves)
            )
        )
        setupSpinner()
    }

    private fun getSliderText(position: Int): NiveisEnum {
        if (position <= 1) return NiveisEnum.INICIANTE
        if (position in 2..2) return NiveisEnum.BASICO
        if (position in 3..3) return NiveisEnum.CASUAL
        if (position in 4..4) return NiveisEnum.AVANCADO
        return NiveisEnum.INICIANTE
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.title.toString() == "Salvar") {
            if (validate()) {
                save()
            } else {
                Toast.makeText(this, "Preencha os campos corretamente!", Toast.LENGTH_SHORT).show()
            }
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_signup, menu)
        return true
    }

    private fun save() {
        usuario.email = binding.editTextEmailSignUp.text.toString()
        usuario.senha = binding.editTextPasswordSignUp.text.toString()
        usuario.nome = binding.editTextNameSignUp.text.toString()
        usuario.cidade = binding.editTextTownSignUp.text.toString()
        usuario.dataNascimento = binding.editTextBirthSignUp.text.toString()
        usuario.foto = getByteArrayFromBitmap(photo)
        usuario.console = ConsoleRepository(this).getConsoleByName(binding.spinnerConsoleName.selectedItem.toString())

        when(binding.slider.value.toInt()) {
            1 -> {
                usuario.nivel = NiveisEnum.INICIANTE
            }
            2 -> {
                usuario.nivel = NiveisEnum.BASICO
            }
            3 -> {
                usuario.nivel = NiveisEnum.CASUAL
            }
            4 -> {
                usuario.nivel = NiveisEnum.AVANCADO
            }
        }

        if(binding.buttonMasc.isChecked) {
            usuario.sexo = 'M'
        } else if (binding.buttonFem.isChecked) {
            usuario.sexo = 'F'
        }

        usuarioRepository = UsuarioRepository(this)
        val id = usuarioRepository.save(usuario)
        if (id > 0) {
            Toast.makeText(this, "ID: $id", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun validate(): Boolean {
        if (binding.editTextEmailSignUp.text.isEmpty()) {
            binding.editTextEmailSignUp.error = "Email is required!"
            return false
        } else if (binding.editTextPasswordSignUp.text.isEmpty()) {
            binding.editTextPasswordSignUp.error = "Password is required!"
            return false
        } else if (binding.editTextNameSignUp.text.isEmpty()) {
            binding.editTextNameSignUp.error = "Name is required!"
            return false
        } else if (binding.editTextTownSignUp.text.isEmpty()) {
            binding.editTextTownSignUp.error = "Town is required!"
            return false
        } else if (binding.editTextBirthSignUp.text.isEmpty()) {
            binding.editTextBirthSignUp.error = "Birth Date is required!"
            return false
        }
        return true
    }

    private fun getImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK) {
            photo = getBitmapFromUri(data?.data, this)
        }
    }

    private fun setupSpinner()  {
        val listOfConsoles = ConsoleRepository(this).getAll().map { e -> e.nome }
        binding.spinnerConsoleName.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listOfConsoles)
    }
}