package com.example.my_pplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import  android.widget.Button

class MainActivity : AppCompatActivity() {
    public final var APP_PREFERENCES = "mysettings"
    lateinit var settings:SharedPreferences
    lateinit var editPass: EditText
    lateinit var editEmail: EditText

    var hasVisited:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collectetion_screen)
       //get preferences

        settings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
        val emaill : String = settings.getString("email", "") ?: ""
        val paroll : String = settings.getString("parol","") ?: ""
        hasVisited = emaill.isNotEmpty()

        editPass = findViewById((R.id.parol))
        editEmail = findViewById((R.id.email))

        if(hasVisited)
        {
            editEmail.setText(emaill)
        }
    }

    fun NextButton(view: View) {
        val hasPassword = editPass.text.toString().isNotEmpty()
        val hasEmail = editEmail.text.toString().isNotEmpty()

        when {
              !hasPassword || !hasEmail ->
            AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Незаполнены поля!!!")
                .setPositiveButton("Ок",null)
                .create()
                .show()
            !hasVisited -> {
                val password = editPass.getText().toString()
                val email = editEmail.getText().toString()
                val prefEditor = settings.edit()
                prefEditor.putString("password", password)
                prefEditor.putString("email", email)
                prefEditor.apply()
                val intent = Intent(this, CollectetionScreen::class.java)
                startActivity((intent))
            }
            else -> {
                var code = editPass.getText().toString();
                var getpas = settings.getString("password","nopas")
                if (code == getpas)
                {
                    val intent = Intent(this, CollectetionScreen::class.java)
                    startActivity((intent))
                }
                else {
                    AlertDialog.Builder(this)
                        .setTitle("Ошибка")
                        .setMessage("Неверный пароль!")
                        .setPositiveButton("Ок",null)
                        .create()
                        .show()
                }

            }
        }
    }
    fun clear(view: View) {
        val e: SharedPreferences.Editor = settings.edit()
        e.clear()
        e.apply()
    }

}