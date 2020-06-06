package com.mani.newshunter.features.main


import android.os.Bundle
import android.util.Log
import android.view.View
import com.mani.domain.entities.Resource
import com.mani.domain.entities.Status
import com.mani.domain.entities.model.TopHeadlineVO
import com.mani.newshunter.R
import com.mani.newshunter.databinding.ActivityMainBinding
import com.mani.newshunter.features.main.ext.observe
import com.mani.newshunter.ui.base.app.BaseActivity
import com.mani.newshunter.ui.base.app.viewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var vm: MainViewModel

    override fun getContentViewId(): Int {
       return R.layout.activity_main
    }

    override fun getRootLayoutContainer(): View {
      return root_layout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModels()
        observe(vm.topheadLinesData,::onDataLoaded)
    }

    private fun onDataLoaded(resource: Resource<TopHeadlineVO>?) {
        when(resource?.status){
            Status.LOADING->{}
            Status.SUCCESS->{
                Log.d("MANISH"," dfkdjf  ${resource.data?.articles?.get(0)?.title}")
            }
            Status.ERROR->{
                Log.d("MANISH"," ${resource.error}")
            }
        }
    }


    private fun initViewModels() {
        vm = viewModel(viewModelFactory)
    }

    override fun onResume() {
        super.onResume()
        vm.loadTopheadlinesFromIndia()
    }

    companion object{
        private const val tag = "MainActivity"
    }

}


