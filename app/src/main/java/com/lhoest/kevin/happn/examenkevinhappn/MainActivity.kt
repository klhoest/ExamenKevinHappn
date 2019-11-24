package com.lhoest.kevin.happn.examenkevinhappn

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.lhoest.kevin.happn.examenkevinhappn.di.DaggerMainComponent
import com.lhoest.kevin.happn.examenkevinhappn.viewmodel.ForecastViewModel
import javax.inject.Inject

@Suppress("MemberVisibilityCanBePrivate")
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
        if (savedInstanceState == null) {
            loadFirstFragment()
        }
    }

    fun listenViewModel() {
        model.showLoading.observe(this, Observer { isDisplayed -> Log.d(TAG, "showDialog = $isDisplayed") })
        model.itemClickLiveData.observe(this, Observer { id -> showDetailFragment(id) })
    }

    fun loadFirstFragment() {
        val firstFragment = SummaryFragment()
        supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, firstFragment).commit()
    }

    fun showDetailFragment(id : Int) {
        val newFragment = DetailFragment.newInstance(id)

        val transaction = supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, newFragment)
            //addToBackStack(null)
        }
        transaction.commit();

    }
}
