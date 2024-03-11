package com.vit.assessment.presentation.features.match

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vit.assessment.core.result.Result
import com.vit.assessment.domain.usecase.FetchMatchesUseCase
import com.vit.assessment.presentation.features.match.adapter.MatchViewData
import com.vit.assessment.presentation.features.match.adapter.mapToViewData
import com.vit.assessment.presentation.features.team.TeamViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author vietth
 * @since 11/03/2024
 */
@HiltViewModel
class MatchViewModel @Inject constructor(
    private val fetchMatchesUseCase: FetchMatchesUseCase
): ViewModel() {

    val matchesLiveData: LiveData<List<MatchViewData>>
        get() = _matchesLiveData
    private val _matchesLiveData = MutableLiveData<List<MatchViewData>>(emptyList())

    fun fetchMatches() {
        viewModelScope.launch {
            when(val result = fetchMatchesUseCase()) {
                is Result.Success -> {
                    _matchesLiveData.value = result.data.mapToViewData()
                }
                is Result.Error -> {
                    Log.e(TeamViewModel::class.java.name, result.exception.message, result.exception)
                }
            }
        }
    }

}