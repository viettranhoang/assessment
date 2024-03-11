package com.vit.assessment.presentation.features.team.adapter

import androidx.recyclerview.widget.DiffUtil
import com.vit.assessment.domain.model.Team

/**
 * @author vietth
 * @since 09/03/2024
 */
data class TeamViewData(
    val id: String,
    val name: String?,
    val logo: String?
) {
    override fun hashCode(): Int {
        return id.hashCode() + name.hashCode() + logo.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return if (other !is TeamViewData) false
        else other.id == id && other.name == name && other.logo == logo
    }

    object DiffCallback : DiffUtil.ItemCallback<TeamViewData>() {
        override fun areItemsTheSame(
            oldItem: TeamViewData,
            newItem: TeamViewData
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: TeamViewData,
            newItem: TeamViewData
        ): Boolean {
            return oldItem == newItem
        }
    }
}

fun Team.mapToViewData() = TeamViewData(id, name, logo)

fun List<Team>.mapToViewData() = map { it.mapToViewData() }