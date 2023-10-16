package com.duongvn.politicalpreparedness.representative

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.duongvn.politicalpreparedness.data.repository.remote.RepresentativesRepository
import com.duongvn.politicalpreparedness.data.repository.remote.RepresentativesRepositoryImpl

class RepresentativeViewModelFactory(
    private val representativesRepository: RepresentativesRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RepresentativeViewModel::class.java)) {
            return RepresentativeViewModel(representativesRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }

    companion object {
        fun getInstance(): RepresentativeViewModelFactory {
            return RepresentativeViewModelFactory(
                RepresentativesRepositoryImpl()
            )
        }
    }
}