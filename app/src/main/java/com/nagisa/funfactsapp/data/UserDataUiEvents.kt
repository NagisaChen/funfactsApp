package com.nagisa.funfactsapp.data

/**
 * 密封类，用来表示用户输入的事件，包括用户输入名字和选择动物
 * 当用户输入名字或者选择动物时，会触发事件，事件会改变用户输入的状态
 * 密封类是一种特殊的类，它可以有一定数量的子类，但这些子类必须在与密封类相同的文件中声明。
 * 这种特性使得密封类非常适合用于表示限定的类层次结构，当某个值为密封类的类型时，可以确保该值只能是有限的几种类型之一，没有其他可能。
 * */
sealed class UserDataUiEvents {
    data class UserNameEntered(val name: String) : UserDataUiEvents()
    data class AnimalSelected(val animal: String) : UserDataUiEvents()
}