package com.example.openai

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.image.ImageCreation
import com.aallam.openai.api.image.ImageSize
import com.aallam.openai.api.image.ImageURL
import com.aallam.openai.client.OpenAI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val apiKey = BuildConfig.API_KEY
    val openAI = OpenAI(apiKey)

    var data = MutableLiveData<String>()

    @OptIn(BetaOpenAI::class)
    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val image =
                openAI.imageURL(
                    creation = ImageCreation(
                        prompt = "Animation",
                        n = 1,
                        size = ImageSize.is256x256
                    )
                )
            Log.d("viewmodelLog", "$image")
//            postValue(image)
        }
    }

    @OptIn(BetaOpenAI::class)
    private fun postValue(imageURL: List<ImageURL>) {
        data.postValue(imageURL[0].url)
    }
}

