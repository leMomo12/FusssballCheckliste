package com.mnowo.fuballcheckliste.presentation.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
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
import com.mnowo.fuballcheckliste.presentation.FullGameScreen.FullGameScreen
import com.mnowo.fuballcheckliste.presentation.FullTrainingScreen.FullTrainingScreen
import com.mnowo.fuballcheckliste.ui.theme.*
import com.mnowo.fuballcheckliste.util.BottomSheetScreen
import com.mnowo.fuballcheckliste.util.model.Checkbox
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeScreenViewModel = hiltViewModel()) {
    val trainingList: List<Checkbox> by viewModel.trainingListData.observeAsState(initial = emptyList())
    val gameList: List<Checkbox> by viewModel.gameListData.observeAsState(initial = emptyList())

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()

    var currentBottomSheet: BottomSheetScreen? by remember {
        mutableStateOf(null)
    }

    if (scaffoldState.bottomSheetState.isCollapsed)
        currentBottomSheet = null

    if (scaffoldState.bottomSheetState.isCollapsed)
        currentBottomSheet = null

    val closeSheet: () -> Unit = {
        scope.launch {
            scaffoldState.bottomSheetState.collapse()
        }
    }

    val openSheet: (BottomSheetScreen) -> Unit = {
        scope.launch {
            currentBottomSheet = it
            scaffoldState.bottomSheetState.expand()
        }
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetShape = BottomSheetShape,
        sheetContent = {
            currentBottomSheet?.let { currentSheet ->
                SheetLayout(currentSheet, closeSheet)
            }
        },
        sheetPeekHeight = 56.dp,
    ) { paddingValues ->
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
                gameListData = gameList,
                openSheet = openSheet
            )
        }
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
    gameListData: List<Checkbox>,
    openSheet: (BottomSheetScreen) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
    ) {
        HomeScreenCardBody(trainingListData, gameListData, openSheet)
    }
}

@Composable
fun HomeScreenCardBody(
    trainingListData: List<Checkbox>,
    gameListData: List<Checkbox>,
    openSheet: (BottomSheetScreen) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(5.dp, top = 45.dp)
    ) {

        ChecklistChipRow(text = stringResource(R.string.checklistForTraining), openSheet)
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        TrainingList(trainingListData)
        Spacer(modifier = Modifier.padding(vertical = 40.dp))
        ChecklistChipRow(text = stringResource(R.string.checklistForGame), openSheet)
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
            ListItem(text = it.message)
        }
    }
}


@Composable
fun GameList(
    gameListData: List<Checkbox>
) {
    LazyColumn {
        items(gameListData) {
           ListItem(text = it.message)
        }
    }
}

@Composable
fun ListItem(text: String) {
    Row(modifier = Modifier.padding(start = 30.dp, top = 8.dp, end = 8.dp, bottom = 8.dp)) {
        val isChecked = remember { mutableStateOf(false) }
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it },
            enabled = true,

            )
        Spacer(modifier = Modifier.padding(horizontal = 10.dp))
        Text(text = text)
    }
}

@Composable
fun ChecklistChipRow(text: String, openSheet: (BottomSheetScreen) -> Unit) {
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
                .clickable {
                    if (text == "Checklist for training") {
                        openSheet(BottomSheetScreen.FullTrainingScreen)
                    } else {
                        openSheet(BottomSheetScreen.FullGameScreen)
                    }
                },
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
fun SheetLayout(currentScreen: BottomSheetScreen, onCloseBottomSheet: () -> Unit) {
    BottomSheetWithCloseDialog(onCloseBottomSheet) {
        when (currentScreen) {
            BottomSheetScreen.FullGameScreen -> FullGameScreen()
            BottomSheetScreen.FullTrainingScreen -> FullTrainingScreen()
        }
    }
}

@Composable
fun BottomSheetWithCloseDialog(
    onClosePressed: () -> Unit,
    modifier: Modifier = Modifier,
    closeButtonColor: Color = Color.Gray,
    content: @Composable () -> Unit
) {
    Box(modifier.fillMaxWidth()) {
        content()

        IconButton(
            onClick = onClosePressed,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
                .size(29.dp)

        ) {
            Icon(Icons.Filled.Close, tint = closeButtonColor, contentDescription = null)
        }

    }
}

