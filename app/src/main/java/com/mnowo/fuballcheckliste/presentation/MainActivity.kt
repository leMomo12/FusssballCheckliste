package com.mnowo.fuballcheckliste.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.mnowo.fuballcheckliste.ui.theme.FußballChecklisteTheme
import com.mnowo.fuballcheckliste.util.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FußballChecklisteTheme {
                val navController = rememberNavController()
                Navigation(navHostController = navController)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FußballChecklisteTheme {

    }
}