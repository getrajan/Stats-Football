package com.Stats.Football.data.repository

import com.Stats.Football.common.Constants.login
import com.Stats.Football.common.Constants.token
import com.Stats.Football.data.remote.MatchDto.MatchDto
import com.Stats.Football.data.remote.MoreInfoDto.MoreInfoDto
import com.Stats.Football.data.remote.SportStatApi
import com.Stats.Football.data.remote.TeamSquadDto.TeamSquadDto
import com.Stats.Football.domain.repository.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val api: SportStatApi
) : AppRepository {
    override suspend fun getMatches(): MatchDto {
        return api.getMatches()
    }

    override suspend fun getTeamSquad(teamId: String): TeamSquadDto {
        return api.getTeamSquad(
            login = login,
            token = token,
            task = "squaddata",
            team = teamId
        )
    }

    override suspend fun getPlayerMoreInfo(playerId: String): MoreInfoDto {
        return api.getPlayerMoreInfo(
            login = login,
            token = token,
            task = "playerdata",
            player = playerId
        )
    }
}