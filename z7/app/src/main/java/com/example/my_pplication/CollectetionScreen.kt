package com.example.my_pplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CollectetionScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)
    }
    fun clicks (view: View) {
        val intent = Intent(this, Films::class.java)
        startActivity((intent))

    }
}