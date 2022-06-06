package com.Stats.Football.presentation.match

import com.Stats.Football.domain.model.SquadMember

data class TeamSquadState(
    val isLoading: Boolean = false,
    val squadMemberList: List<SquadMember> = emptyList(),
    val error: String = ""
)