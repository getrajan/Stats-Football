package com.Stats.Football.data.remote

import com.Stats.Football.common.Constants.login
import com.Stats.Football.common.Constants.token
import com.Stats.Football.data.remote.MatchDto.MatchDto
import com.Stats.Football.data.remote.MoreInfoDto.MoreInfoDto
import com.Stats.Football.data.remote.TeamSquadDto.TeamSquadDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SportStatApi {
    @GET("get.php?login=$login&token=$token&task=predata&sport=soccer&day=today")
    suspend fun getMatches(): MatchDto

    @GET("get.php")
    suspend fun getTeamSquad(
        @Query("login") login: String,
        @Query("token") token: String,
        @Query("task") task: String,
        @Query("team") team: String,
    ): TeamSquadDto

    @GET("get.php")
    suspend fun getPlayerMoreInfo(
        @Query("login") login: String,
        @Query("token") token: String,
        @Query("task") task: String,
        @Query("player") player: String,
    ): MoreInfoDto
}