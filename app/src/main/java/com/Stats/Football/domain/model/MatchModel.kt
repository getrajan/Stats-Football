package com.Stats.Football.domain.model


data class MatchModel(
    val away: AwayModel,
    val gameId: String,
    val home: HomeModel,
    val league: LeagueModel,
    val time: String,
    val timeStatus: String
)
