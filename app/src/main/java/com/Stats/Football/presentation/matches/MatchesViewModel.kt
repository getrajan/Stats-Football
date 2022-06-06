package com.Stats.Football.presentation.matches

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Stats.Football.common.Resource
import com.Stats.Football.domain.usecase.GetMatchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MatchesViewModel @Inject constructor(
    val getMatchesUseCase: GetMatchesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MatchesState())
    val state: State<MatchesState> = _state

    init {
        getMatches()
    }

    private fun getMatches() {
        getMatchesUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = MatchesState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = MatchesState(matchList = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = MatchesState(error = result.message ?: "Unexpected Error Occurs")
                }
            }
        }.launchIn(viewModelScope)
    }
}