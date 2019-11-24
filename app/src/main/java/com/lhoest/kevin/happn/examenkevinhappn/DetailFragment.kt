package com.lhoest.kevin.happn.examenkevinhappn


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.lhoest.kevin.happn.examenkevinhappn.di.DaggerMainComponent
import com.lhoest.kevin.happn.examenkevinhappn.viewmodel.ForecastViewModel
import kotlinx.android.synthetic.main.fragment_detail.view.*
import javax.inject.Inject

private const val DAY_ID = "DAY_ID"

class DetailFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: ForecastViewModel
    private var dayId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dayId = it.getInt(DAY_ID)
        }
        this.activity?.let { activity ->
            val component = DaggerMainComponent.create()
            viewModelFactory = component.viewModelFactory
            viewModel = ViewModelProviders.of(activity, viewModelFactory)[ForecastViewModel::class.java]
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        view.raw_content.text = viewModel.dayList
                ?.find { day -> day.dt == dayId }
                .toString()
        return view
    }


    companion object {
        @JvmStatic
        fun newInstance(dayId: Int) =
                DetailFragment().apply {
                    arguments = Bundle().apply {
                        putInt(DAY_ID, dayId)
                    }
                }
    }
}
