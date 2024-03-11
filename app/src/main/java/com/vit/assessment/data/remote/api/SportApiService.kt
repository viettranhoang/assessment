package com.vit.assessment.data.remote.api

import com.vit.assessment.data.remote.model.response.FetchMatchesResponse
import com.vit.assessment.data.remote.model.response.FetchTeamsResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author vietth
 * @since 07/03/2024
 */
interface SportApiService {
    @GET("teams")
    suspend fun fetchTeams(): FetchTeamsResponse

    @GET("teams/matches")
    suspend fun fetchMatches(): FetchMatchesResponse

    @GET("teams/{id}/matches")
    suspend fun fetchTeamMatches(@Path("id") teamId: String): FetchMatchesResponse

    companion object {
        const val BASE_URL = "https://jmde6xvjr4.execute-api.us-east-1.amazonaws.com/"
    }
}

