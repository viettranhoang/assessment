package com.vit.assessment.presentation.features.match.adapter.item.upcoming

import com.vit.assessment.R
import com.vit.assessment.presentation.features.match.adapter.MatchViewData

data class MatchUpcomingViewData(
    override val itemId: String,
    val date: String?,
    val description: String?,
    val home: String?,
    val away: String?,
    val homeLogo: String?,
    val awayLogo: String?,
): MatchViewData {

    override val layoutRes: Int = R.layout.match_upcoming_item

    override fun shallowCopy(): MatchViewData = copy()

    override fun areContentsTheSame(matchViewData: MatchViewData): Boolean {
        return if (matchViewData !is MatchUpcomingViewData) false
        else date == matchViewData.date && description == matchViewData.description && home == matchViewData.home
    }
}