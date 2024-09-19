package com.example.imageview.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.imageview.R
import com.example.imageview.model.Photo

class PhotoViewModel : ViewModel() {
    private val _photos = listOf(
        Photo(R.drawable.photo1),
        Photo(R.drawable.photo2),
        Photo(R.drawable.photo3),
        Photo(R.drawable.photo4),
        Photo(R.drawable.photo5)
    )
    private val _currentPhotoIndex = MutableLiveData(0)
    val currentPhotoIndex: LiveData<Int> get() = _currentPhotoIndex

    val currentPhoto: LiveData<Photo> = _currentPhotoIndex.map { index ->
        _photos[index]
    }

    fun nextPhoto() {
        if (_currentPhotoIndex.value!! < _photos.size - 1) {
            _currentPhotoIndex.value = _currentPhotoIndex.value!! + 1
        }
    }

    fun isLastPhoto(): Boolean {
        return _currentPhotoIndex.value == _photos.size - 1
    }
}
