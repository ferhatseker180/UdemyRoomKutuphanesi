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

     //   kisileriYukle()
      //   ekle()
     //   guncelle()
     //   sil()
       // rastgele()
      //  ara()
      //  getir()
        kontrol()

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
            val yeniKisi = Kisiler(0,"Ferhat",24)
            val yeniKisi2 = Kisiler(0,"Ferhat",24)
            val yeniKisi3 = Kisiler(0,"Figen",49)
            kdao.kisiEkle(yeniKisi)
            kdao.kisiEkle(yeniKisi2)
            kdao.kisiEkle(yeniKisi3)


        }
    }

    fun guncelle() {

        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenKisi = Kisiler(3,"Yeni Ahmet",92)
            kdao.kisiGuncelle(guncellenenKisi)
        }
    }

    fun sil() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenKisi = Kisiler(2,"",0)
            kdao.kisiSil(silinenKisi)
        }
    }

    fun rastgele() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val gelenListe = kdao.rastgeleKisiGetir()

            for (k in gelenListe) {
                Log.e("Kişi id",k.kisi_id.toString())
                Log.e("Kişi ad",k.kisi_ad)
                Log.e("Kişi yaş",k.kisi_yas.toString())

            }
        }
    }

    fun ara() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val gelenListe = kdao.kisiAra("h")

            for (k in gelenListe) {
                Log.e("Kişi id",k.kisi_id.toString())
                Log.e("Kişi ad",k.kisi_ad)
                Log.e("Kişi yaş",k.kisi_yas.toString())

            }
        }
    }

    fun getir() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val gelenKisi = kdao.kisiGetir(3)

           Log.e("Kişi id",gelenKisi.kisi_id.toString())
            Log.e("Kişi ad",gelenKisi.kisi_ad)
            Log.e("Kişi yaş",gelenKisi.kisi_yas.toString())

        }
    }

    fun kontrol() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val gelenSonuc = kdao.kisiKontrol("Ferhat")

            Log.e("Kişi Kontrol",gelenSonuc.toString())


        }
    }

}