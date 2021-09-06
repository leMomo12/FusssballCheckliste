package com.mnowo.fuballcheckliste.presentation.FullGameScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnowo.fuballcheckliste.util.model.Checkbox
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FullGameScreenViewModel @Inject constructor(

) : ViewModel() {

    private val _fullGameListData = MutableLiveData<MutableList<Checkbox>>()
    val fullGameListData: LiveData<MutableList<Checkbox>> = _fullGameListData

    init {
        fullGameList()
    }

    private fun fullGameList() = viewModelScope.launch {
        _fullGameListData.postValue(
            mutableListOf(
                Checkbox(false, "Heim Trikot"),
                Checkbox(false, "Auswärts Trikot"),
                Checkbox(false, "Heim Hose"),
                Checkbox(false, "Auswärts Hose"),
                Checkbox(false, "Fusßballschuhe"),
                Checkbox(false, "Schienbeinschoner"),
                Checkbox(false, "Stutzen Heim"),
                Checkbox(false, "Stutzen Auswärts"),
                Checkbox(false, "Neue Socken"),
                Checkbox(false, "Handtuch"),
                Checkbox(false, "Unterhose"),
                Checkbox(false, "Badeschlappen"),
                Checkbox(false, "Trinken"),
            )
        )
    }

}