package com.example.common_base.base.viewmodel

sealed class StateActionEvent

object LoadingState : StateActionEvent()

object SuccessState : StateActionEvent()

class ErrorState(val message: String?) : StateActionEvent()