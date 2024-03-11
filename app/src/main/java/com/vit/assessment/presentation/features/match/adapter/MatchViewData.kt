package com.vit.assessment.presentation.features.match.adapter

import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import com.vit.assessment.core.time.convertToReadableDateString
import com.vit.assessment.domain.model.Match
import com.vit.assessment.domain.model.Matches
import com.vit.assessment.presentation.features.match.adapter.item.finished.MatchFinishedViewData
import com.vit.assessment.presentation.features.match.adapter.item.upcoming.MatchUpcomingViewData

/**
 * @author vietth
 * @since 11/03/2024
 */
interface MatchViewData {
    val itemId: String

    val layoutRes: Int

    fun shallowCopy(): MatchViewData

    fun areContentsTheSame(matchViewData: MatchViewData): Boolean

    object DiffCallback : DiffUtil.ItemCallback<MatchViewData>() {
        override fun areItemsTheSame(
            oldItem: MatchViewData,
            newItem: MatchViewData
        ): Boolean {
            return oldItem.itemId == newItem.itemId
        }

        override fun areContentsTheSame(
            oldItem: MatchViewData,
            newItem: MatchViewData
        ): Boolean {
            return oldItem.areContentsTheSame(newItem)
        }
    }

    class LiveData : MutableLiveData<List<MatchViewData>>() {

        override fun setValue(value: List<MatchViewData>) {
            super.setValue(value.map { it.shallowCopy() })
        }

        override fun postValue(value: List<MatchViewData>) {
            super.postValue(value.map { it.shallowCopy() })
        }
    }
}

fun List<Match>.mapToUpcomingViewData() = map {
    MatchUpcomingViewData(
        it.description + it.date,
        convertToReadableDateString(it.date),
        it.description,
        it.home.name?.removePrefix("Team "),
        it.away.name?.removePrefix("Team "),
        it.home.logo,
        it.away.logo
    )
}

fun List<Match>.mapToFinishedViewData() = map {
    MatchFinishedViewData(
        it.description + it.date,
        convertToReadableDateString(it.date),
        it.home.name?.removePrefix("Team "),
        it.away.name?.removePrefix("Team "),
        it.winner?.removePrefix("Team "),
        it.highlights,
        it.home.logo,
        it.away.logo
    )
}

fun Matches.mapToViewData(): List<MatchViewData> {
    return mutableListOf<MatchViewData>().apply {
        addAll(upcoming.mapToUpcomingViewData())
        addAll(previous.mapToFinishedViewData())
    }
}