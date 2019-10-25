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

private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class DetailFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: ForecastViewModel
    private var param1: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
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
                ?.find { day -> day.dt == param1 }
                .toString()
        return view
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: Int) =
                DetailFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_PARAM1, param1)
                    }
                }
    }
}
