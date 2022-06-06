package com.Stats.Football.presentation.match

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Stats.Football.common.Resource
import com.Stats.Football.domain.model.MatchModel
import com.Stats.Football.domain.usecase.GetTeamSquadUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(
    val getTeamSquadUseCase: GetTeamSquadUseCase
) : ViewModel() {
    private val _teamState = mutableStateOf<TeamEnum>(TeamEnum.TEAM1)
    val teamState: State<TeamEnum> = _teamState

    private val _squadMemberListState = mutableStateOf(TeamSquadState())
    val squadMemberListState: State<TeamSquadState> = _squadMemberListState

    private val _nMatch = mutableStateOf<MatchModel?>(null)
    val targetedMatch: State<MatchModel?> = _nMatch

    private val _teamPhotoUrl = mutableStateOf<String?>(null)
    val teamPhotoUrl: State<String?> = _teamPhotoUrl

    fun setNavigatedMatch(match: MatchModel) {
        viewModelScope.launch {
            _nMatch.value = match
            toggleTeams(TeamEnum.TEAM1)
        }
    }

    fun toggleTeams(teamEnum: TeamEnum) {
        viewModelScope.launch {
            _teamState.value = teamEnum
            when (_teamState.value) {
                TeamEnum.TEAM1 -> {
                    getTeamSquad(teamId = targetedMatch.value?.home!!.id)
                    _teamPhotoUrl.value = targetedMatch.value?.home!!.id
                }
                TeamEnum.TEAM2 -> {
                    getTeamSquad(teamId = targetedMatch.value?.away!!.id)
                    _teamPhotoUrl.value = targetedMatch.value?.away!!.id
                }
            }
        }
    }

    private fun getTeamSquad(teamId: String) {
        getTeamSquadUseCase(teamId = teamId).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _squadMemberListState.value = TeamSquadState(isLoading = true)
                }
                is Resource.Success -> {
                    _squadMemberListState.value =
                        TeamSquadState(squadMemberList = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _squadMemberListState.value =
                        TeamSquadState(error = result.message ?: "Unexpected Error Occurs")
                }
            }
        }.launchIn(viewModelScope)
    }
}

enum class TeamEnum { TEAM1, TEAM2 }