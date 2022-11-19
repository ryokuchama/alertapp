package com.example.alertapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

class SettingActivity : ComponentActivity() {

//    private _model: SettingModel = new SettingModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingView()
        }
    }
}

@Preview
@Composable
fun SettingView() {
    val viewModel: SettingViewModel = remember {
        SettingViewModel(SettingModel() as ISettingModel)
    }
    // remember=Composableな関数で値を保持できる
    // 再Composeされたタイミングで取得する
    // Activityが破棄されると値は削除される 削除したくない場合はrememberSavableを使う
    val minute by viewModel.value.collectAsState()
    Column {
        // declaration
        Text(text = "煽る間隔を設定(分)")
        // Setting minutes
        Text(
            text = minute.toString()
        )
        // increment button
        Button(
            onClick = viewModel::onValueIncrement
        ){
            Text(text = "+")
        }
        // decrement button
        Button(
            onClick = viewModel::onValueDecrement
        ){
            Text(text = "-")
        }
    }
}