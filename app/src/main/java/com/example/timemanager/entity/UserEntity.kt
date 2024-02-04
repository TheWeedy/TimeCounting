package com.example.timemanager.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Wordlist")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    @ColumnInfo
    var word:String,
)