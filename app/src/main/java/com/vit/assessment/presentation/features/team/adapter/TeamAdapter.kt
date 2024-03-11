package com.vit.assessment.presentation.features.team.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vit.assessment.databinding.TeamItemBinding

/**
 * @author vietth
 * @since 09/03/2024
 */
class TeamAdapter(
    private val context: Context,
): ListAdapter<TeamViewData, TeamAdapter.ViewHolder>(
    TeamViewData.DiffCallback
) {
    private val layoutInflater = LayoutInflater.from(context)

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TeamItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(context, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)
        holder.onViewRecycled()
    }

    class ViewHolder(
        private val context: Context,
        private val binding: TeamItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TeamViewData) {
            with(binding) {
                textName.text = item.name
                Glide.with(context)
                    .load(item.logo)
                    .circleCrop()
                    .into(imageLogo)
            }

        }

        fun onViewRecycled() {
            //TODO clear image
        }
    }


}