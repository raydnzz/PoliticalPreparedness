package com.duongvn.politicalpreparedness.data.repository.remote

import com.duongvn.politicalpreparedness.base.Result
import com.duongvn.politicalpreparedness.network.CivicsApi
import com.duongvn.politicalpreparedness.network.base.ApiService
import com.duongvn.politicalpreparedness.network.models.RepresentativeResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class RepresentativesRepositoryImpl(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : RepresentativesRepository {
    private var apiService: ApiService<RepresentativeResponse>? = null

    override suspend fun fetch(address: String): Result<RepresentativeResponse> =
        withContext(dispatcher) {
            try {
                apiService = CivicsApi.fetchRepresentatives(address)
                val result = apiService?.fetch() ?: throw Exception("API Error")
                Result.SUCCESS(result)
            } catch (e: Exception) {
                Result.ERROR(e.localizedMessage)
            }
        }

    override suspend fun cancel() {
        apiService?.cancel()
    }
}

interface RepresentativesRepository {
    suspend fun fetch(address: String): Result<RepresentativeResponse>
    suspend fun cancel()
}
