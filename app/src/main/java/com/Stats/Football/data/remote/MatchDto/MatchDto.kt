package com.Stats.Football.data.remote.MatchDto

data class MatchDto(
    val capacity_requests: String,
    val date_games: String,
    val games_pre: List<GamesPre>,
    val last_time_your_key: String,
    val remain_requests: String,
    val time_request: Double
)