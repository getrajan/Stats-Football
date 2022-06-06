package com.Stats.Football.domain.model

data class PlayerInfo(
    val assists: String,
    val blockedShots: String,
    val corner: String,
    val goals: String,
    val minutesPlayed: String,
    val offside: String,
    val redCard: String,
    val shots: String,
    val shots_on_goal: String,
    val starting: String,
    val substitutedIn: String,
    val substitutedOut: String,
    val team_uid: String,
    val updated_at: String,
    val yellowCard: String,
    val yellowRedCard: String
)

fun List<PlayerInfo>.toPlayerInfo(): PlayerInfo {
    var assists: Int = 0
    var blockedShots: Int = 0
    var corner: Int = 0
    var goals: Int = 0
    var minutesPlayed: Int = 0
    var offside: Int = 0
    var redCard: Int = 0
    var shots: Int = 0
    var shots_on_goal: Int = 0
    var starting: Int = 0
    var substitutedIn: Int = 0
    var substitutedOut: Int = 0
    var yellowCard: Int = 0
    var yellowRedCard: Int = 0

    this.forEach { info ->
        assists += if (info.assists.isNotBlank()) info.assists.toInt() else 0
        blockedShots += if (info.blockedShots.isNotBlank()) info.blockedShots.toInt() else 0
        corner += if (info.corner.isNotBlank()) info.corner.toInt() else 0
        goals += if (info.goals.isNotBlank()) info.goals.toInt() else 0
        minutesPlayed += if (info.minutesPlayed.isNotBlank()) info.minutesPlayed.toInt() else 0
        offside += if (info.offside.isNotBlank()) info.offside.toInt() else 0
        redCard += if (info.redCard.isNotBlank()) info.redCard.toInt() else 0
        shots += if (info.shots.isNotBlank()) info.shots.toInt() else 0
        shots_on_goal += if (info.shots_on_goal.isNotBlank()) info.shots_on_goal.toInt() else 0
        starting += if (info.starting.isNotBlank()) info.starting.toInt() else 0
        substitutedIn += if (info.substitutedIn.isNotBlank()) info.substitutedIn.toInt() else 0
        substitutedOut += if (info.substitutedOut.isNotBlank()) info.substitutedOut.toInt() else 0
        yellowCard += if (info.yellowCard.isNotBlank()) info.yellowCard.toInt() else 0
        yellowRedCard += if (info.yellowRedCard.isNotBlank()) info.yellowRedCard.toInt() else 0
    }
    return PlayerInfo(
        assists = assists.toString(),
        blockedShots = blockedShots.toString(),
        corner = corner.toString(),
        goals = goals.toString(),
        minutesPlayed = minutesPlayed.toString(),
        offside = offside.toString(),
        redCard = redCard.toString(),
        shots = shots.toString(),
        shots_on_goal = shots_on_goal.toString(),
        starting = starting.toString(),
        substitutedOut = substitutedOut.toString(),
        substitutedIn = substitutedIn.toString(),
        yellowRedCard = yellowRedCard.toString(),
        yellowCard = yellowCard.toString(),
        team_uid = "",
        updated_at = "",
    )
}