package com.example.roommaster.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import androidx.room.Update

@Dao
interface ISexo {
    @Query("SELECT * FROM Sexo")
    fun Get(): List<Sexo>

    @Query("SELECT * FROM Sexo WHERE id = :id")
    suspend fun Get(id: Int): Sexo

    @Insert(onConflict = IGNORE)
    suspend fun Add(Sexo: Sexo)

    @Update(onConflict = IGNORE)
    suspend fun Update(Sexo: Sexo)

    @Delete
    suspend fun Delete(Sexo: Sexo)

}