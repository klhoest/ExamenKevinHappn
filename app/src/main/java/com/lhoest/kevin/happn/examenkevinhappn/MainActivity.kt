package com.lhoest.kevin.happn.examenkevinhappn

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.lhoest.kevin.happn.examenkevinhappn.di.DaggerMainComponent
import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import com.lhoest.kevin.happn.examenkevinhappn.ui.ForecastViewModel
import javax.inject.Inject

class MainActivity : FragmentActivity() {

    private val TAG: String = this.javaClass.simpleName

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var model: ForecastViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val component = DaggerMainComponent.create()
        viewModelFactory = component.viewModelFactory
        model = ViewModelProviders.of(this, viewModelFactory)[ForecastViewModel::class.java]
        listenViewModel()
    }

    fun listenViewModel() {
        val nameObserver = Observer<List<Day>> { list -> Log.d(TAG, "list is : ${list.first()}") }
        model.showLoading.observe(this, Observer { isDisplayed -> Log.d(TAG, "showDialog = $isDisplayed") })
        model.forcast.observe(this, nameObserver)
    }
}
