package com.mnowo.fuballcheckliste.presentation.FullTrainingScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnowo.fuballcheckliste.util.model.Checkbox
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FullTrainingScreenViewModel @Inject constructor(

) : ViewModel() {

    private val _fullTrainingListData = MutableLiveData<MutableList<Checkbox>>()
    val fullTrainingListData: LiveData<MutableList<Checkbox>> = _fullTrainingListData

    init {
        fullTrainingList()
    }

   private  fun fullTrainingList() = viewModelScope.launch {
        _fullTrainingListData.postValue(
            mutableListOf(
                Checkbox(false, "Trikot"),
                Checkbox(false, "Hose"),
                Checkbox(false, "Fusßballschuhe"),
                Checkbox(false, "*Schienbeinschoner"),
                Checkbox(false, "*Stutzen Heim"),
                Checkbox(false, "*Stutzen Auswärts"),
                Checkbox(false, "Neue Socken"),
                Checkbox(false, "Handtuch"),
                Checkbox(false, "Unterhose"),
                Checkbox(false, "Badeschlappen"),
                Checkbox(false, "Trinken"),
            )
        )
    }
}