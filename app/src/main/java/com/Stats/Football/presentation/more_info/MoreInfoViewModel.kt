package com.Stats.Football.presentation.more_info

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Stats.Football.common.Resource
import com.Stats.Football.domain.model.SquadMember
import com.Stats.Football.domain.usecase.GetMoreInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoreInfoViewModel @Inject constructor(
    val getMoreInfoUseCase: GetMoreInfoUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MoreInfoState())
    val state: State<MoreInfoState> = _state

    private val _nPlayer = mutableStateOf<SquadMember?>(null)
    val player: State<SquadMember?> = _nPlayer

    fun setPlayer(player: SquadMember) {
        viewModelScope.launch {
            _nPlayer.value = player
            getMoreInfo()
        }
    }

    fun getMoreInfo() {
        getMoreInfoUseCase(player.value!!.id).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = MoreInfoState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = MoreInfoState(error = result.message ?: "Unexpected Error")
                }
                is Resource.Success -> {
                    _state.value = MoreInfoState(infoList = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}