package com.example.testsecondtry.database

import androidx.room.Entity
import androidx.room.PrimaryKey


//table name
@Entity(tableName = "PhotoTable")
data class PhotoEntity(

    // table contents
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val photoTitle: String,
    val PhotoLink: String
)