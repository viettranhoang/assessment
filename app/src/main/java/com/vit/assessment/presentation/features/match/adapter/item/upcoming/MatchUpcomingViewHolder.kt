package com.vit.assessment.presentation.features.match.adapter.item.upcoming

import android.os.Bundle
import com.bumptech.glide.Glide
import com.vit.assessment.R
import com.vit.assessment.databinding.MatchUpcomingItemBinding
import com.vit.assessment.presentation.features.match.adapter.MatchViewHolder

/**
 * @author vietth
 * @since 11/03/2024
 */
class MatchUpcomingViewHolder(
    private val binding: MatchUpcomingItemBinding,
) : MatchViewHolder<MatchUpcomingItemBinding, MatchUpcomingViewData>(binding) {

    override fun onBind(item: MatchUpcomingViewData, bundle: Bundle?) {
        with(binding) {
            textStatus.text = context.getString(R.string.upcoming_match)
            textDate.text = item.date
            textTeamHome.text = item.home
            textTeamAway.text = item.away
            Glide.with(context)
                .load(item.homeLogo)
                .circleCrop()
                .into(imageTeamHome)
            Glide.with(context)
                .load(item.awayLogo)
                .circleCrop()
                .into(imageTeamAway)
        }
    }

    override fun onViewRecycled() {
    }
}