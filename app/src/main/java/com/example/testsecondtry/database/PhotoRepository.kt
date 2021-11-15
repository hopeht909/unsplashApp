package com.example.testsecondtry.database

import androidx.lifecycle.LiveData


class PhotoRepository(private val photoDao: PhotoDao) {

    val getPhotos: LiveData<List<PhotoEntity>> = photoDao.getPhotos()

    suspend fun addPhoto(item: PhotoEntity){
        photoDao.addPhoto(item)
    }


    suspend fun deletePhoto(showID : Int){
        photoDao.deletePhoto(showID)
    }

}