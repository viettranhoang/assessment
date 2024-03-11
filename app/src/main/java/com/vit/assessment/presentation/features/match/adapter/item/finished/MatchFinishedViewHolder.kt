package com.vit.assessment.presentation.features.match.adapter.item.finished

import android.os.Bundle
import com.bumptech.glide.Glide
import com.vit.assessment.R
import com.vit.assessment.databinding.MatchFinishedItemBinding
import com.vit.assessment.presentation.features.match.adapter.MatchViewHolder

/**
 * @author vietth
 * @since 11/03/2024
 */
class MatchFinishedViewHolder(
    private val binding: MatchFinishedItemBinding,
) : MatchViewHolder<MatchFinishedItemBinding, MatchFinishedViewData>(binding) {

    override fun onBind(item: MatchFinishedViewData, bundle: Bundle?) {
        with(binding) {
            textStatus.text = context.getString(R.string.finished_match)
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
            if (item.winner == item.home) {
                imageTeamHome.alpha = 1f
                imageTeamHome.setBackgroundResource(R.drawable.match_win_bg)
                imageTeamAway.background = null
                imageTeamAway.alpha = 0.5f
            } else {
                imageTeamAway.alpha = 1f
                imageTeamAway.setBackgroundResource(R.drawable.match_win_bg)
                imageTeamHome.background = null
                imageTeamHome.alpha = 0.5f

            }
        }
    }

    override fun onViewRecycled() {
    }
}