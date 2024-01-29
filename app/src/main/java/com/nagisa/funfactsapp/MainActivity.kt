package com.nagisa.funfactsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nagisa.funfactsapp.ui.screens.FunFactsNavigationGraph
import com.nagisa.funfactsapp.ui.screens.Routes
import com.nagisa.funfactsapp.ui.screens.UserInputScreen
import com.nagisa.funfactsapp.ui.screens.WelcomeScreen
import com.nagisa.funfactsapp.ui.theme.FunFactsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FunFactsAppTheme {
                FunFactsApp()
            }
        }
    }
}

@Composable
fun FunFactsApp() {
    FunFactsNavigationGraph()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FunFactsAppTheme {

    }
}