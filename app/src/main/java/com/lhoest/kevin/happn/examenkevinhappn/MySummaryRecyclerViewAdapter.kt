package com.lhoest.kevin.happn.examenkevinhappn

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


import com.lhoest.kevin.happn.examenkevinhappn.dummy.DummyContent.DummyItem
import com.lhoest.kevin.happn.examenkevinhappn.viewmodel.ForecastViewModel

import kotlinx.android.synthetic.main.fragment_summary.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem]
 * TODO: Replace the implementation with code for your data type.
 */
class MySummaryRecyclerViewAdapter(
        private val mValues: List<DummyItem>,
        private val viewModel: ForecastViewModel)
    : RecyclerView.Adapter<MySummaryRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DummyItem
            viewModel.onSummaryItemClicked(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_summary, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.titleTv.text = item.id
        holder.subtitleTv.text = item.content

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val titleTv: TextView = mView.title
        val subtitleTv: TextView = mView.subTitle
        val temperature: TextView = mView.temperature

        override fun toString(): String {
            return super.toString() + " '" + subtitleTv.text + "'"
        }
    }
}
