package com.example.androidconcurrency2020

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import java.nio.charset.Charset

class MainViewModel: ViewModel() {

    val myData = MutableLiveData<String>()

    fun doWork() {
        viewModelScope.launch {
            myData.value = fetchSomething()
        }
    }

    private suspend fun fetchSomething(): String {
        return withContext(Dispatchers.IO) {
            val url = URL(fileUrl)
            return@withContext url.readText(Charset.defaultCharset())
        }
    }
}