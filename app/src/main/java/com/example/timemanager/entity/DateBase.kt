package com.example.timemanager.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.timemanager.dao.UserDao

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    //写在内存里的数据库
    companion object{
        private var db:AppDatabase?=null
        private val name="app"
        fun getDB(context: Context)=if (db==null){
            Room.inMemoryDatabaseBuilder(context,AppDatabase::class.java).build().apply {
                db=this
            }
        }else{
            db!!
        }
    }
    abstract fun userDao(): UserDao
}
