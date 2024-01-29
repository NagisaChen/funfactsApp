package com.nagisa.funfactsapp.data

/**
 * 数据类，用来表示用户输入的状态，包括用户输入的名字和选择的动物，当用户输入名字或者选择动物时，会触发事件，事件会改变用户输入的状态
 * 用作状态记录，和事件类（一般密封）一起联合使用，事件触发时修改相应的状态数据
 * 在这里，一共有两个状态数据，一个是用户输入的名字nameEntered，一个是用户选择的动物animalSelected
 * */
data class UserInputScreenState(
    val nameEntered: String = "",
    val animalSelected: String = ""
)
