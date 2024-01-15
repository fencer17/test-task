package com.example.testtask.ui.photoList

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.domain.repos.AlbumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    @ApplicationContext context: Context,
    private val albumRepository: AlbumRepository
) : AndroidViewModel(context as Application) {

    val albumFlow = albumRepository.getAlbumFlow()

    init {
        viewModelScope.launch {
            albumRepository.syncAlbumsList()
        }
    }
}