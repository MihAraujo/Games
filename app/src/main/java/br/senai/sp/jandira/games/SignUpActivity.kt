package br.senai.sp.jandira.games

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_signup, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

            Toast.makeText(this, "Your information has been saved", Toast.LENGTH_SHORT).show()
            return true
    }

}