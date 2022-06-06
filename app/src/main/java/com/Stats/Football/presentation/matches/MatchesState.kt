package com.Stats.Football.presentation.matches

import com.Stats.Football.domain.model.MatchModel

data class MatchesState(
    val isLoading: Boolean = false,
    val matchList: List<MatchModel> = emptyList(),
    val error: String = ""
)
