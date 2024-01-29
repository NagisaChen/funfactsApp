package com.nagisa.funfactsapp.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nagisa.funfactsapp.data.UserDataUiEvents
import com.nagisa.funfactsapp.data.UserInputScreenState

/**
 * ViewModel一般是一个用来管理UI的状态的类，当UI的状态发生变化时，ViewModel会通知UI进行更新
 * 因此ViewModel类中会包括一个成员变量记录UI的状态，以及一个函数用来更新UI的状态
 * */
class UserInputViewModel : ViewModel() {

    companion object {
        const val TAG = "UserInputViewModel"
    }

    var uiState = mutableStateOf(UserInputScreenState())

    /**
     * 根据传入的事件类型，更新用户输入的状态，同时更改到uiState的变量当中去
     * */
    fun onEvent(event: UserDataUiEvents) {
        when (event) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
                Log.d(TAG, "onEvent:UsernameEntered->> ")
                Log.d(TAG, "${uiState.value}")
            }

            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animalSelected = event.animal
                )
                Log.d(TAG, "onEvent:UsernameEntered->> ")
                Log.d(TAG, "${uiState.value}")
            }
        }
    }

    fun isValidState(): Boolean {
        return !uiState.value.nameEntered.isNullOrEmpty() && !uiState.value.animalSelected.isNullOrEmpty()
    }
}