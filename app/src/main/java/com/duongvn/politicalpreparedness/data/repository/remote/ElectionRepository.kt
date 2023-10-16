package com.duongvn.politicalpreparedness.data.repository.remote

import com.duongvn.politicalpreparedness.network.CivicsApi
import com.duongvn.politicalpreparedness.network.base.ApiService
import com.duongvn.politicalpreparedness.network.models.ElectionResponse
import com.duongvn.politicalpreparedness.base.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ElectionRepositoryImpl(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ElectionRepository {
    private var apiService: ApiService<ElectionResponse>? = null
    override suspend fun fetch(): Result<ElectionResponse> = withContext(dispatcher) {
        try {
            apiService = CivicsApi.fetchElections()
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

interface ElectionRepository {
    suspend fun fetch(): Result<ElectionResponse>
    suspend fun cancel()
}