package com.vit.assessment.data.remote.model

import com.google.gson.annotations.SerializedName
import com.vit.assessment.domain.model.Team

/**
 * @author vietth
 * @since 07/03/2024
 */
data class TeamDto(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String?,
    @SerializedName("logo") val logo: String?
)

fun TeamDto.mapToDomain() = Team(id, name, logo)

fun List<TeamDto>.mapToDomain() = map { it.mapToDomain() }