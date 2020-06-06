package com.mani.newshunter.features.main


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.mani.domain.entities.Resource
import com.mani.domain.entities.Status
import com.mani.domain.entities.model.TopHeadlineVO
import com.mani.newshunter.R
import com.mani.newshunter.databinding.ActivityMainBinding
import com.mani.newshunter.ext.observe
import com.mani.newshunter.ui.base.app.BaseActivity
import com.mani.newshunter.ui.base.app.viewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var vm: MainViewModel
    private lateinit var newsRecyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter

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
        newsAdapter= NewsAdapter(this)
        newsRecyclerView = binding.recyclerViewNews
        newsRecyclerView.apply {
            adapter = newsAdapter
            addItemDecoration(DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL))
            (itemAnimator as DefaultItemAnimator).run {
                supportsChangeAnimations = false
                addDuration = 160L
                moveDuration = 160L
                changeDuration = 160L
                removeDuration = 120L
            }
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                }
            })
        }

    }

    private fun onDataLoaded(resource: Resource<TopHeadlineVO>?) {
        when(resource?.status){
            Status.LOADING->{}
            Status.SUCCESS->{
                resource.data?.articles?.let {
                    newsAdapter.submitList(it)
                }
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
        vm.loadTopheadlines()
    }

    companion object{
        private const val tag = "MainActivity"
    }

}


