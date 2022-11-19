package com.example.alertapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SettingViewModel(private val model: ISettingModel): ISettingViewModel, ViewModel() {
    private var _model: ISettingModel = model
    private val _value = MutableStateFlow(0)
    val value: StateFlow<Int> = _value

    override fun onValueIncrement() {
        _value.value++
    }

    override fun onValueDecrement() {
        if (_value.value > 0){
            _value.value--
        }
    }

    override fun setTimer() {
        _model.setTimer(_value.value)
    }

    override fun stopTimer() {
        _model.stopTimer()
    }
}