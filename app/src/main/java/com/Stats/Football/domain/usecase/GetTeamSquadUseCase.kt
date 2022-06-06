package com.Stats.Football.domain.usecase

import com.Stats.Football.common.Resource
import com.Stats.Football.data.remote.TeamSquadDto.toSquad
import com.Stats.Football.domain.model.SquadMember
import com.Stats.Football.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTeamSquadUseCase @Inject constructor(private val appRepository: AppRepository) {
    operator fun invoke(teamId: String): Flow<Resource<List<SquadMember>>> = flow {
        try {
            emit(Resource.Loading<List<SquadMember>>())
            val teamSquadResponse = appRepository.getTeamSquad(teamId = teamId)
            val squadList = teamSquadResponse.results.map { it.toSquad() }
            emit(Resource.Success<List<SquadMember>>(data = squadList))
        } catch (e: HttpException) {
            emit(Resource.Error<List<SquadMember>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<SquadMember>>("Could not reach server. Check your internet connection"))
        }
    }
}