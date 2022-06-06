package com.Stats.Football.presentation.more_info

import com.Stats.Football.domain.model.PlayerInfo

data class MoreInfoState(
    val isLoading: Boolean = false,
    val infoList: List<PlayerInfo> = emptyList(),
    val error: String = ""
)