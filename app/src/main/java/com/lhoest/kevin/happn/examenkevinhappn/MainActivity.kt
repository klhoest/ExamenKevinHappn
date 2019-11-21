package com.lhoest.kevin.happn.examenkevinhappn

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.room.Room
import com.lhoest.kevin.happn.examenkevinhappn.datasource.storage.DayRoomDatabase
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
        val db = Room.databaseBuilder(
                applicationContext,
                DayRoomDatabase::class.java, "day-database"
        ).build()
        viewModelFactory = component.viewModelFactory
        model = ViewModelProviders.of(this, viewModelFactory)[ForecastViewModel::class.java]
        model.dayRepo.dayServiceStorage = db.dayDao()
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
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            replace(R.id.fragment_container, newFragment)
            //addToBackStack(null)
        }
        transaction.commit();

    }
}
