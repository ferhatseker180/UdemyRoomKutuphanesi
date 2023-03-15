package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var vt : Veritabani
    private lateinit var kdao : KisilerDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vt = Veritabani.veritabaniErisim(this)!!
        kdao = vt.getkisilerDao()

    }
}