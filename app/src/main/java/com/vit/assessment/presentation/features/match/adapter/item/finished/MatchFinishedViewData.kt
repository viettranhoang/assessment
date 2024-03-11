package com.vit.assessment.presentation.features.match.adapter.item.finished

import com.vit.assessment.R
import com.vit.assessment.presentation.features.match.adapter.MatchViewData

data class MatchFinishedViewData(
    override val itemId: String,
    val date: String?,
    val home: String?,
    val away: String?,
    val winner: String?,
    val highlights: String?,
    val homeLogo: String?,
    val awayLogo: String?,
): MatchViewData {

    override val layoutRes: Int = R.layout.match_finished_item

    override fun shallowCopy(): MatchViewData = copy()

    override fun areContentsTheSame(matchViewData: MatchViewData): Boolean {
        return if (matchViewData !is MatchFinishedViewData) false
        else date == matchViewData.date && highlights == matchViewData.highlights && home == matchViewData.home && away == matchViewData.away
    }
}