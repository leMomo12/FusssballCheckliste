package com.mnowo.fuballcheckliste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mnowo.fuballcheckliste.ui.theme.FußballChecklisteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FußballChecklisteTheme {

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