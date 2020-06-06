package com.mani.newshunter.ui.base.app

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by Manish Kumar
 */
abstract class BaseActivity<B : ViewDataBinding>: DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var binding: B

    abstract fun getContentViewId(): Int
    abstract fun getRootLayoutContainer(): View

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getContentViewId())
    }


}
inline fun <reified T : ViewModel> FragmentActivity.viewModel(
    factory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, factory)[T::class.java]
}