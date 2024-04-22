package com.example.saturninterview.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ExampleViewModel: ViewModel() {
    companion object {
        val defaultViewModel: ExampleViewModel by lazy {
            ExampleViewModel()
        }
    }

    val response: MutableStateFlow<String> = MutableStateFlow("")

    fun getData() {
        viewModelScope.launch {
            val result = ExampleAPI.retrofitService.getData()
            response.value = result.toString() ?: "No Data"
        }
    }
}