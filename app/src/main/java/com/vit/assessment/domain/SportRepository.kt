package com.vit.assessment.domain

import com.vit.assessment.domain.model.Matches
import com.vit.assessment.domain.model.Team

/**
 * @author vietth
 * @since 09/03/2024
 */
interface SportRepository {
    suspend fun fetchTeams(): List<Team>

    suspend fun fetchMatches(): Matches

    suspend fun fetchTeamMatches(teamId: String): Matches
}