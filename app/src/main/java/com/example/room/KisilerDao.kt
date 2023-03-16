package com.example.room

import androidx.room.*

@Dao
interface KisilerDao {
@Query("SELECT * FROM kisiler")
    suspend fun tumKisiler() : List<Kisiler>

    @Insert
    suspend fun kisiEkle(kisi:Kisiler)

    @Update
    suspend fun kisiGuncelle(kisi: Kisiler)

    @Delete
    suspend fun kisiSil(kisi: Kisiler)

    @Query("SELECT * FROM kisiler ORDER BY RANDOM() LIMIT 1") // Kayıtlar random şekilde sınırladığımız sayıda gelecek.
    suspend fun rastgeleKisiGetir() : List<Kisiler>

    @Query("SELECT * FROM kisiler WHERE kisi_ad like '%' || :aramaKelimesi || '%'")
    suspend fun kisiAra(aramaKelimesi : String?) : List<Kisiler>

    // Tek satır halinde kayıt getirme
    @Query("SELECT * FROM kisiler WHERE kisi_id=:kisi_id")
    suspend fun kisiGetir(kisi_id : Int) : Kisiler

    // Kayıt Kontrol
    @Query("SELECT count(*) FROM kisiler WHERE kisi_ad=:kisi_ad")
    suspend fun kisiKontrol(kisi_ad : String) : Int

}