package com.example.factorial

sealed class State(
)
class isError : State()
class isFactorial(val text : String) : State()
class isProgressBar : State()