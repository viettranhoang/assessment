package com.vit.assessment.presentation.features.match.adapter.item.title

import com.vit.assessment.R
import com.vit.assessment.presentation.features.match.adapter.MatchViewData

data class MatchTitleViewData(
    override val itemId: String,
    val title: String
): MatchViewData {

    override val layoutRes: Int = R.layout.match_title_item

    override fun shallowCopy(): MatchViewData = copy()

    override fun areContentsTheSame(matchViewData: MatchViewData): Boolean {
        return if (matchViewData !is MatchTitleViewData) false
        else title == matchViewData.title
    }
}