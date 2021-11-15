package com.example.testsecondtry.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.testsecondtry.database.PhotoDatabase
import com.example.testsecondtry.database.PhotoEntity
import com.example.testsecondtry.database.PhotoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(application: Application): AndroidViewModel(application) {
    private val repository: PhotoRepository
    private val shows: LiveData<List<PhotoEntity>>

    init {
        val photoDao = PhotoDatabase.getDatabase(application).showDao()
        repository = PhotoRepository(photoDao)
        shows = repository.getPhotos
    }

    fun getPhotos(): LiveData<List<PhotoEntity>>{
        return shows
    }

    fun addPhoto(photoTitle: String, photoLink: String){
        CoroutineScope(Dispatchers.IO).launch {
            repository.addPhoto(PhotoEntity(0,photoTitle,photoLink))
        }
    }

    fun deletePhoto(ID : Int){
        CoroutineScope(Dispatchers.IO).launch {
            repository.deletePhoto(ID)
        }
    }
}