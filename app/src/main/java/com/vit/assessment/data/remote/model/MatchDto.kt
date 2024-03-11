package com.vit.assessment.data.remote.model

import com.google.gson.annotations.SerializedName
import com.vit.assessment.domain.model.Match
import com.vit.assessment.domain.model.Team

/**
 * @author vietth
 * @since 07/03/2024
 */
data class MatchDto(
    @SerializedName("date") val date: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("home") val home: String?,
    @SerializedName("away") val away: String?,
    @SerializedName("winner") val winner: String?,
    @SerializedName("highlights") val highlights: String?
)

fun List<MatchDto>.mapToDomain(teams: List<Team>) = mapNotNull { dto ->
    val home = teams.find { it.name == dto.home }
    val away = teams.find { it.name == dto.away }
    if (home == null || away == null) return@mapNotNull null
    Match(dto.date, dto.description, home, away, dto.winner, dto.highlights)
}