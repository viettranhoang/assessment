package com.vit.assessment.presentation.features.match.adapter.item.title

import android.os.Bundle
import com.vit.assessment.databinding.MatchTitleItemBinding
import com.vit.assessment.presentation.features.match.adapter.MatchViewHolder

/**
 * @author vietth
 * @since 11/03/2024
 */
class MatchTitleViewHolder(
    private val binding: MatchTitleItemBinding,
) : MatchViewHolder<MatchTitleItemBinding, MatchTitleViewData>(binding) {

    override fun onBind(item: MatchTitleViewData, bundle: Bundle?) {
        binding.textTitle.text = item.title
    }

    override fun onViewRecycled() {
    }
}