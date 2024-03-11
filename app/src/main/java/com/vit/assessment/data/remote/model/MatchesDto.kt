package com.vit.assessment.data.remote.model

import com.google.gson.annotations.SerializedName
import com.vit.assessment.domain.model.Matches

/**
 * @author vietth
 * @since 07/03/2024
 */
data class MatchesDto(
    @SerializedName("previous") val previous: List<MatchDto>,
    @SerializedName("upcoming") val upcoming: List<MatchDto>
) {
    companion object {
        fun empty() = MatchesDto(emptyList(), emptyList())
    }
}

