package com.vit.assessment.presentation.features.match.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.vit.assessment.R
import com.vit.assessment.databinding.MatchFinishedItemBinding
import com.vit.assessment.databinding.MatchTitleItemBinding
import com.vit.assessment.databinding.MatchUpcomingItemBinding
import com.vit.assessment.presentation.features.match.adapter.item.finished.MatchFinishedViewHolder
import com.vit.assessment.presentation.features.match.adapter.item.upcoming.MatchUpcomingViewHolder
import com.vit.assessment.presentation.features.match.adapter.item.title.MatchTitleViewHolder

/**
 * @author vietth
 * @since 09/03/2024
 */
abstract class MatchViewHolder<in B : ViewBinding, in T : MatchViewData>(
    binding: B
) : RecyclerView.ViewHolder(binding.root) {

    protected val context: Context
        get() = itemView.context

    protected val parentRecyclerView: RecyclerView?
        get() = itemView.parent as? RecyclerView

    abstract fun onBind(item: T, bundle: Bundle?)

    open fun onViewRecycled() {}

    open fun onViewAttachedToWindow() {}

    open fun onViewDetachedFromWindow() {}

    open fun onDetachedFromRecyclerView() {}
}

class MatchViewHolderFactory(
    context: Context,
) {
    private val layoutInflater = LayoutInflater.from(context)

    fun create(parent: ViewGroup, viewType: Int): MatchViewHolder<*, *> {
        return when (viewType) {
            R.layout.match_upcoming_item -> MatchUpcomingViewHolder(
                MatchUpcomingItemBinding.inflate(layoutInflater, parent, false),
            )
            R.layout.match_finished_item -> MatchFinishedViewHolder(
                MatchFinishedItemBinding.inflate(layoutInflater, parent, false),
            )
            R.layout.match_title_item -> MatchTitleViewHolder(
                MatchTitleItemBinding.inflate(layoutInflater, parent, false)
            )
            else -> throw IllegalArgumentException()
        }
    }
}