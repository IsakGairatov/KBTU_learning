package com.example.apiassignment.ui.main
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiassignment.data.api.TestRepo
import com.example.apiassignment.models.Manga
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: TestRepo):ViewModel() {
    private val _all = MutableLiveData<Manga>()
    val all: LiveData<Manga>
        get() = _all

    init {
        getAll()
    }

    fun getAll() = viewModelScope.launch {
        repository.getAll().let {
            if(it.isSuccessful) {
                _all.postValue(it.body())

            } else {
                Log.d("checkData", "Failed to load mangas: ${it.errorBody()}")
            }
        }
    }
}