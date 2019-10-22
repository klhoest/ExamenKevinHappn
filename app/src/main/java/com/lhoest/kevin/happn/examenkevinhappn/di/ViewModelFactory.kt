package com.lhoest.kevin.happn.examenkevinhappn.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lhoest.kevin.happn.examenkevinhappn.repository.DayRepository
import com.lhoest.kevin.happn.examenkevinhappn.ui.ForecastViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val dayRepo: DayRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ForecastViewModel(dayRepo) as T
    }
}