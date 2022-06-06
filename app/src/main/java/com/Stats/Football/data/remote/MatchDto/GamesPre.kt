package com.Stats.Football.data.remote.MatchDto

import com.Stats.Football.domain.model.MatchModel

data class GamesPre(
    val away: Away,
    val game_id: String,
    val home: Home,
    val league: League,
    val time: String,
    val time_status: String
)

fun GamesPre.toMatchModel(): MatchModel {
    return MatchModel(
        away = away.toAwayModel(),
        gameId = game_id,
        home = home.toHomeModel(),
        league = league.toLeagueModel(),
        time = time,
        timeStatus = time_status
    )
}