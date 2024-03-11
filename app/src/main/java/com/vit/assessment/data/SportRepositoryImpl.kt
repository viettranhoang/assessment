package com.vit.assessment.data

import com.vit.assessment.core.coroutine.CoroutineDispatchers
import com.vit.assessment.data.remote.SportRemote
import com.vit.assessment.data.remote.model.mapToDomain
import com.vit.assessment.domain.SportRepository
import com.vit.assessment.domain.model.Matches
import com.vit.assessment.domain.model.Team
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author vietth
 * @since 07/03/2024
 */
class SportRepositoryImpl @Inject constructor(
    private val remote: SportRemote,
    private val appDispatchers: CoroutineDispatchers
) : SportRepository {

    override suspend fun fetchTeams(): List<Team> {
        return withContext(appDispatchers.io) {
            remote.fetchTeams().mapToDomain()
        }
    }

    override suspend fun fetchMatches(): Matches {
        return withContext(appDispatchers.io) {
            val teams = remote.fetchTeams().mapToDomain()
            val matchesDto = remote.fetchMatches()
            Matches(
                matchesDto.previous.mapToDomain(teams),
                matchesDto.upcoming.mapToDomain(teams)
            )
        }
    }

    override suspend fun fetchTeamMatches(teamId: String): Matches {
        return withContext(appDispatchers.io) {
            val teams = remote.fetchTeams().mapToDomain()
            val matchesDto = remote.fetchTeamMatches(teamId)
            Matches(
                matchesDto.previous.mapToDomain(teams),
                matchesDto.upcoming.mapToDomain(teams)
            )
        }
    }
}