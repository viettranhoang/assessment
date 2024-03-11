package com.vit.assessment.domain.usecase

import com.vit.assessment.core.result.Result
import com.vit.assessment.domain.SportRepository
import com.vit.assessment.domain.exception.SportExceptionHandler
import com.vit.assessment.domain.model.Matches
import javax.inject.Inject

class FetchMatchesUseCase @Inject constructor(
    private val repository: SportRepository,
    private val exceptionHandler: SportExceptionHandler
) {

    suspend operator fun invoke(): Result<Matches> {
        return try {
            val result = repository.fetchMatches()
            Result.Success(result)
        } catch (e: Exception) {
            Result.Error(exceptionHandler(e))
        }
    }
}