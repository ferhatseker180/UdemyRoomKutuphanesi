package com.example.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface KisilerDao {
@Query("SELECT * FROM kisiler")
    suspend fun tumKisiler() : List<Kisiler>

    @Insert
    suspend fun kisiEkle(kisi:Kisiler)

}