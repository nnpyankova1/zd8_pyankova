package com.example.my_pplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Films : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_films)
    }
    fun clicks2 (view: View) {
        val intent = Intent(this, Film4::class.java)
        startActivity((intent))

    }
    fun clicks3 (view: View) {
        val intent = Intent(this, Film2::class.java)
        startActivity((intent))

    }
    fun clicks4 (view: View) {
        val intent = Intent(this, Film3::class.java)
        startActivity((intent))

    }
    fun clicks5 (view: View) {
        val intent = Intent(this, Film5::class.java)
        startActivity((intent))

    }
    fun clicks6 (view: View) {
        val intent = Intent(this, Viborfilmov::class.java)
        startActivity((intent))

    }
    fun clicks7 (view: View) {
        val intent = Intent(this, Film6::class.java)
        startActivity((intent))

    }
    fun clicks8 (view: View) {
        val intent = Intent(this, Films::class.java)
        startActivity((intent))

    }

}