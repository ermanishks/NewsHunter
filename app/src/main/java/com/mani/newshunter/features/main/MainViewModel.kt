package com.mani.newshunter.features.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mani.domain.entities.Resource
import com.mani.domain.entities.model.TopHeadlineVO
import com.mani.domain.usecase.FetchTopHeadlineUseCase
import com.mani.newshunter.ui.base.app.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.system.measureTimeMillis

/**
 * Created by Manish Kumar
 */
class MainViewModel @Inject constructor(
    private val topHeadlineUseCase: FetchTopHeadlineUseCase
) : BaseViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.d("MANISH", "   ${Thread.currentThread().name}  ")
    }
    val topheadLinesData = MutableLiveData<Resource<TopHeadlineVO>>()

    fun loadTopheadlines() {
        topheadLinesData.value = Resource.loading(null)
        viewModelScope.launch(exceptionHandler) {
            val elapsedTime = measureTimeMillis {
                val headlinesVO = topHeadlineUseCase.execute()
                topheadLinesData.value = headlinesVO
            }
            Log.d("MANISH"," elapsedTime  $elapsedTime")
        }
    }
}