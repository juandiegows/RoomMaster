package com.example.roommaster.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Sexo::class], version = 1)
abstract class IDatabase : RoomDatabase() {

    abstract fun SexoDAO(): ISexo

    companion object {
        @Volatile
        private var INSTANCIA: IDatabase? = null

        fun GetDataBase(context: Context): IDatabase {
            if (INSTANCIA != null) {
                return INSTANCIA!!
            }

            INSTANCIA = Room.databaseBuilder(
                context.applicationContext,
                IDatabase::class.java,
                "DBTest"
            ).build()
            return INSTANCIA!!

        }


    }
}
