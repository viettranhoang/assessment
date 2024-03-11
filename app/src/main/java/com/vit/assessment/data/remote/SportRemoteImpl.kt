package com.vit.assessment.data.remote

import com.vit.assessment.data.remote.api.SportApiService
import com.vit.assessment.data.remote.model.MatchesDto
import com.vit.assessment.data.remote.model.TeamDto
import javax.inject.Inject

/**
 * @author vietth
 * @since 07/03/2024
 */
class SportRemoteImpl @Inject constructor(
    private val sportApi: SportApiService
) : SportRemote {

    override suspend fun fetchTeams(): List<TeamDto> {
        return sportApi.fetchTeams().teams
    }

    override suspend fun fetchMatches(): MatchesDto {
        return sportApi.fetchMatches().matches ?: MatchesDto.empty()
    }

    override suspend fun fetchTeamMatches(teamId: String): MatchesDto {
        return sportApi.fetchTeamMatches(teamId).matches ?: MatchesDto.empty()
    }

}