package com.mnowo.fuballcheckliste.presentation.HomeScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnowo.fuballcheckliste.util.model.Checkbox
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(

) : ViewModel() {


    private val _trainingListData = MutableLiveData<MutableList<Checkbox>>()
    val trainingListData: LiveData<MutableList<Checkbox>> = _trainingListData

    private val _gameListData = MutableLiveData<MutableList<Checkbox>>()
    val gameListData: LiveData<MutableList<Checkbox>> = _gameListData

    init {
        trainingList()
        gameList()
    }


    fun trainingList() = viewModelScope.launch {
        _trainingListData.postValue(
            mutableListOf(
                Checkbox(false, "Underwear"),
                Checkbox(false, "Shoes"),
                Checkbox(false, "Socks"),
                Checkbox(false, "...")
            )
        )
    }

    fun gameList() = viewModelScope.launch {
        _gameListData.postValue(
            mutableListOf(
                Checkbox(false, "Trikot"),
                Checkbox(false, "Shoes"),
                Checkbox(false, "Socks"),
                Checkbox(false, "...")
            )
        )
    }
}