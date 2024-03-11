package com.vit.assessment.presentation.features.team

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vit.assessment.core.result.Result
import com.vit.assessment.domain.usecase.FetchTeamsUseCase
import com.vit.assessment.presentation.features.team.adapter.TeamViewData
import com.vit.assessment.presentation.features.team.adapter.mapToViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author vietth
 * @since 10/03/2024
 */
@HiltViewModel
class TeamViewModel @Inject constructor(
    private val fetchTeamsUseCase: FetchTeamsUseCase
): ViewModel() {

    val teamsLiveData: LiveData<List<TeamViewData>>
        get() = _teamsLiveData
    private val _teamsLiveData = MutableLiveData<List<TeamViewData>>(emptyList())

    fun fetchTeams() {
        viewModelScope.launch {
            when(val result = fetchTeamsUseCase()) {
                is Result.Success -> {
                    _teamsLiveData.value = result.data.mapToViewData()
                }
                is Result.Error -> {
                    Log.e(TeamViewModel::class.java.name, result.exception.message, result.exception)
                }
            }
        }
    }

}