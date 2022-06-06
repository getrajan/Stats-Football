package com.Stats.Football.presentation.player

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Stats.Football.domain.model.SquadMember
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlayerViewModel @Inject constructor() : ViewModel() {

    private val _nPlayer = mutableStateOf<SquadMember?>(null)
    val player: State<SquadMember?> = _nPlayer

    private val _nTeamPhotoUrl = mutableStateOf<String?>(null)
    val teamPhotoUrl: State<String?> = _nTeamPhotoUrl

    fun setPlayer(player: SquadMember) {
        viewModelScope.launch {
            _nPlayer.value = player
        }
    }

    fun setTeamPhotoUrl(url: String) {
        viewModelScope.launch {
            _nTeamPhotoUrl.value = url
        }
    }
}