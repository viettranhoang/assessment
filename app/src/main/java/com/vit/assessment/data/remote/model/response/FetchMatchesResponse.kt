package com.vit.assessment.data.remote.model.response


import com.google.gson.annotations.SerializedName
import com.vit.assessment.data.remote.model.MatchesDto

/**
 * @author vietth
 * @since 07/03/2024
 */
data class FetchMatchesResponse(
    @SerializedName("matches") val matches: MatchesDto?
)