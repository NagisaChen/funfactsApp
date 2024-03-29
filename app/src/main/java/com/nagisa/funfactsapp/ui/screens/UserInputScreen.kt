package com.nagisa.funfactsapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nagisa.funfactsapp.data.UserDataUiEvents
import com.nagisa.funfactsapp.ui.AnimalCard
import com.nagisa.funfactsapp.ui.TextComponent
import com.nagisa.funfactsapp.ui.TextFiledComponent
import com.nagisa.funfactsapp.ui.TopBar
import com.nagisa.funfactsapp.ui.UserInputViewModel
import com.nagisa.funfactsapp.R
import com.nagisa.funfactsapp.ui.ButtonComponent

@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar("Hi there \uD83D\uDE0A")

            TextComponent(
                textValue = "Let's learn more about you",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.padding(20.dp))

            TextComponent(
                textValue = "This app will prepare a detail page based on input provided by you.",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            TextComponent(textValue = "Name", textSize = 18.sp)

            Spacer(modifier = Modifier.size(10.dp))

            TextFiledComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )
            })

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "What do you like", textSize = 18.sp)

            Row(modifier = Modifier.fillMaxWidth()) {

                AnimalCard(image = R.drawable.cat, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected == "Cat")

                AnimalCard(image = R.drawable.dog, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected == "Dog")

            }

            Spacer(modifier = Modifier.weight(1f))

            if (userInputViewModel.isValidState()) {
                ButtonComponent(goToDetailScreen = {
                })
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserInputScreenPreview() {
    val userInputViewModel = UserInputViewModel()
    UserInputScreen(userInputViewModel)
}