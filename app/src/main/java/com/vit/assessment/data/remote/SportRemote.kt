package com.vit.assessment.data.remote

import com.vit.assessment.data.remote.model.MatchesDto
import com.vit.assessment.data.remote.model.TeamDto

/**
 * @author vietth
 * @since 08/03/2024
 */
interface SportRemote {
    suspend fun fetchTeams(): List<TeamDto>

    suspend fun fetchMatches(): MatchesDto

    suspend fun fetchTeamMatches(teamId: String): MatchesDto
}