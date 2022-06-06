package com.Stats.Football.data.remote.MoreInfoDto

import com.Stats.Football.domain.model.PlayerInfo

data class PlayerInfoDto(
    val assists: String,
    val blocked_shots: String,
    val corner: String,
    val goals: String,
    val minutesplayed: String,
    val offside: String,
    val redcard: String,
    val shots: String,
    val shots_on_goal: String,
    val starting: String,
    val substitutedIn: String,
    val substitutedOut: String,
    val team_uid: String,
    val updated_at: String,
    val yellowcard: String,
    val yellowredcard: String
)

fun PlayerInfoDto.toPlayerInfo(): PlayerInfo {
    return PlayerInfo(
        assists = assists,
        blockedShots = blocked_shots,
        corner = corner,
        goals = goals,
        minutesPlayed = minutesplayed,
        offside = offside,
        redCard = redcard,
        shots = shots,
        shots_on_goal = shots_on_goal,
        starting = starting,
        substitutedIn = substitutedIn,
        substitutedOut = substitutedOut,
        team_uid = team_uid,
        updated_at = updated_at,
        yellowCard = yellowcard,
        yellowRedCard = yellowredcard
    )
}