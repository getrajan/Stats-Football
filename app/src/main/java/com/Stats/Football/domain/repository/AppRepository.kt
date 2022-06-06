package com.Stats.Football.domain.repository

import com.Stats.Football.data.remote.MatchDto.MatchDto
import com.Stats.Football.data.remote.MoreInfoDto.MoreInfoDto
import com.Stats.Football.data.remote.TeamSquadDto.TeamSquadDto

interface AppRepository {

    suspend fun getMatches(): MatchDto

    suspend fun getTeamSquad(teamId: String): TeamSquadDto

    suspend fun getPlayerMoreInfo(playerId: String): MoreInfoDto
}