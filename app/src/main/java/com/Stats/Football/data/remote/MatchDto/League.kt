package com.Stats.Football.data.remote.MatchDto

import com.Stats.Football.domain.model.LeagueModel

data class League(
    val cc: String,
    val id: String,
    val name: String
)

fun League.toLeagueModel(): LeagueModel {
    return LeagueModel(
        cc = cc,
        id = id,
        name = name
    );
}