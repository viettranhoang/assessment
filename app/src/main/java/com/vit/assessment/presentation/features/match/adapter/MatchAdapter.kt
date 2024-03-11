package com.vit.assessment.presentation.features.match.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * @author vietth
 * @since 11/03/2024
 */
class MatchAdapter(
    context: Context
) : ListAdapter<MatchViewData, MatchViewHolder<*, MatchViewData>>(MatchViewData.DiffCallback) {

    private val viewHolderFactory = MatchViewHolderFactory(context)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MatchViewHolder<*, MatchViewData> {
        @Suppress("UNCHECKED_CAST")
        return viewHolderFactory.create(
            parent,
            viewType
        ) as MatchViewHolder<*, MatchViewData>
    }

    override fun onBindViewHolder(holder: MatchViewHolder<*, MatchViewData>, position: Int) {
        val item = getItem(position)
        item?.let { holder.onBind(it, null) }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position)?.layoutRes ?: RecyclerView.NO_POSITION
    }

    override fun onViewRecycled(holder: MatchViewHolder<*, MatchViewData>) {
        holder.onViewRecycled()
    }

    override fun onViewAttachedToWindow(holder: MatchViewHolder<*, MatchViewData>) {
        holder.onViewAttachedToWindow()
    }

    override fun onViewDetachedFromWindow(holder: MatchViewHolder<*, MatchViewData>) {
        holder.onViewDetachedFromWindow()
    }
}