package com.mani.newshunter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.Test

/**
 * Created by Manish Kumar
 */
class MainViewModelTest {
    // Executes tasks in the Architecture Components in the same thread
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Test
    fun no_internet_msg_MainViewModel(){

    }

}