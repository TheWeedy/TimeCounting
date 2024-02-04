package com.example.timemanager.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.timemanager.entity.UserEntity
import com.example.timemanager.ui.screen.mainnav.dictionary.Wordlist

@Dao
interface UserDao {
    @Query("select * from Wordlist")
    fun getAll(): List<UserEntity>
    @Insert
    fun insertUser(userEntity: UserEntity)
    @Delete
    fun delete(word: Wordlist)
}