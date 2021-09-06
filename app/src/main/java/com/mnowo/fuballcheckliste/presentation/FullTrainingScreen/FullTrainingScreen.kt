package com.mnowo.fuballcheckliste.presentation.FullTrainingScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mnowo.fuballcheckliste.presentation.HomeScreen.ListItem
import com.mnowo.fuballcheckliste.util.BottomSheetScreen
import com.mnowo.fuballcheckliste.util.model.Checkbox

@Composable
fun FullTrainingScreen(viewModel: FullTrainingScreenViewModel = hiltViewModel()) {
    val fullTrainingListData: List<Checkbox> by viewModel.fullTrainingListData.observeAsState(initial = emptyList())
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 15.dp, bottom = 15.dp, top = 50.dp)
    ) {
        Text(
            text = "Full Training Checklist",
            fontWeight = FontWeight.Light,
            fontSize = 30.sp,
            modifier = Modifier.padding(start = 30.dp),
            fontFamily = FontFamily.Default
        )
        Spacer(modifier = Modifier.padding(vertical = 15.dp))
        LazyColumn {
            items(fullTrainingListData) {
                ListItem(text = it.message)
            }
        }
    }
}