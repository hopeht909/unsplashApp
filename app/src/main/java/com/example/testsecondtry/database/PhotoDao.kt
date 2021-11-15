package com.example.testsecondtry.database

import androidx.lifecycle.LiveData
import androidx.room.*



@Dao
interface PhotoDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPhoto(item: PhotoEntity)

    @Query("SELECT * FROM PhotoTable ORDER BY id ASC")
    fun getPhotos(): LiveData<List<PhotoEntity>>


    @Query("Delete from PhotoTable where ID=:photoID")
    suspend fun deletePhoto(photoID: Int)

}