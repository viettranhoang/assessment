package com.vit.assessment.domain.usecase

import com.vit.assessment.core.result.Result
import com.vit.assessment.domain.SportRepository
import com.vit.assessment.domain.exception.SportExceptionHandler
import com.vit.assessment.domain.model.Matches
import javax.inject.Inject

class FetchTeamMatchesUseCase @Inject constructor(
    private val repository: SportRepository,
    private val exceptionHandler: SportExceptionHandler
) {

    suspend operator fun invoke(teamId: String): Result<Matches> {
        return try {
            val result = repository.fetchTeamMatches(teamId)
            Result.Success(result)
        } catch (e: Exception) {
            Result.Error(exceptionHandler(e))
        }
    }
}