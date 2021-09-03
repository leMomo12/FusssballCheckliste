package com.mnowo.fuballcheckliste.presentation.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mnowo.fuballcheckliste.R
import com.mnowo.fuballcheckliste.ui.theme.*
import com.mnowo.fuballcheckliste.util.model.Checkbox

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeScreenViewModel = hiltViewModel()) {
    val trainingList: List<Checkbox> by viewModel.trainingListData.observeAsState(initial = emptyList())
    val gameList: List<Checkbox> by viewModel.gameListData.observeAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGreen)
    ) {
        HomeScreenTopAppBar()
        Spacer(modifier = Modifier.padding(vertical = 15.dp))
        HomeScreenCard(
            viewModel,
            trainingListData = trainingList,
            gameListData = gameList
        )
    }
}

@Composable
fun HomeScreenTopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, top = 30.dp)
    ) {
        Text(
            text = stringResource(R.string.checklist),
            fontSize = 30.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif,
        )
    }
}

@Composable
fun HomeScreenCard(
    viewModel: HomeScreenViewModel,
    trainingListData: List<Checkbox>,
    gameListData: List<Checkbox>
) {
    Card(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
    ) {
        HomeScreenCardBody(viewModel = viewModel, trainingListData, gameListData)
    }
}

@Composable
fun HomeScreenCardBody(
    viewModel: HomeScreenViewModel,
    trainingListData: List<Checkbox>,
    gameListData: List<Checkbox>
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(5.dp, top = 45.dp)
    ) {

        ChecklistChipRow(text = stringResource(R.string.checklistForTraining))
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        TrainingList(trainingListData)
        Spacer(modifier = Modifier.padding(vertical = 40.dp))
        ChecklistChipRow(text = stringResource(R.string.checklistForGame))
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        GameList(gameListData = gameListData)
    }
}

@Composable
fun TrainingList(
    trainingListData: List<Checkbox>
) {
    LazyColumn {
        items(trainingListData) {
            Row(modifier = Modifier.padding(start = 30.dp, top = 8.dp, end = 8.dp, bottom = 8.dp)) {
                val isChecked = remember { mutableStateOf(false) }
                Checkbox(
                    checked = isChecked.value,
                    onCheckedChange = { isChecked.value = it },
                    enabled = true,

                    )
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                Text(text = it.message)
            }
        }
    }
}

@Composable
fun GameList(
    gameListData: List<Checkbox>
) {
    LazyColumn {
        items(gameListData) {
            Row(modifier = Modifier.padding(start = 30.dp, top = 8.dp, end = 8.dp, bottom = 8.dp)) {
                val isChecked = remember { mutableStateOf(false) }
                Checkbox(
                    checked = isChecked.value,
                    onCheckedChange = { isChecked.value = it },
                    enabled = true,

                    )
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                Text(text = it.message)
            }
        }
    }
}

@Composable
fun ChecklistChipRow(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp), horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = text,
            fontSize = 22.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Light
        )
        Box(
            modifier = Modifier
                .height(30.dp)
                .width(90.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(chipColor)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.seeAll),
                fontSize = 18.sp,
                color = NormalBlue
            )
        }
    }
}


@Composable
fun GroupedCheckbox(mItemsList: List<String>) {

    mItemsList.forEach { items ->
        Row(modifier = Modifier.padding(8.dp)) {
            val isChecked = remember { mutableStateOf(false) }

            Checkbox(
                checked = isChecked.value,
                onCheckedChange = { isChecked.value = it },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Magenta,
                    uncheckedColor = Color.DarkGray,
                    checkmarkColor = Color.Cyan
                )
            )
            Text(text = items)
        }
    }
}

