package com.Stats.Football.domain.usecase

import android.util.Log
import com.Stats.Football.common.Resource
import com.Stats.Football.data.remote.MatchDto.toMatchModel
import com.Stats.Football.domain.model.MatchModel
import com.Stats.Football.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMatchesUseCase @Inject constructor(
    private val appRepository: AppRepository
) {
    operator fun invoke(): Flow<Resource<List<MatchModel>>> = flow {
        try {
            emit(Resource.Loading<List<MatchModel>>())
            val matchesResponse = appRepository.getMatches()
            val matchList = matchesResponse.games_pre.map { it.toMatchModel() }
            emit(Resource.Success<List<MatchModel>>(data = matchList))
        } catch (e: HttpException) {
            emit(Resource.Error<List<MatchModel>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            Log.d("TAG", "invoke: ${e.message}")
            emit(Resource.Error<List<MatchModel>>("Could not reach server. Check your internet connection"))
        }
    }
}