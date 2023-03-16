package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var vt : Veritabani
    private lateinit var kdao : KisilerDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vt = Veritabani.veritabaniErisim(this)!!
        kdao = vt.getkisilerDao()

        kisileriYukle()
        ekle()
    }
    fun kisileriYukle() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val gelenListe = kdao.tumKisiler()

            for (k in gelenListe) {
                Log.e("Kişi id",k.kisi_id.toString())
                Log.e("Kişi ad",k.kisi_ad)
                Log.e("Kişi yaş",k.kisi_yas.toString())

            }
        }
    }

    fun ekle() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniKisi = Kisiler(0,"Ahmet",30)
            kdao.kisiEkle(yeniKisi)


        }
    }

}