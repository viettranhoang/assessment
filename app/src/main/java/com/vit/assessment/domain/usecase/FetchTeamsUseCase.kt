package com.vit.assessment.domain.usecase

import android.util.Log
import com.vit.assessment.core.result.Result
import com.vit.assessment.domain.SportRepository
import com.vit.assessment.domain.exception.SportExceptionHandler
import com.vit.assessment.domain.model.Team
import javax.inject.Inject

class FetchTeamsUseCase @Inject constructor(
    private val repository: SportRepository,
    private val exceptionHandler: SportExceptionHandler
) {

    suspend operator fun invoke(): Result<List<Team>> {
        return try {
            val result = repository.fetchTeams()
            Log.e("Vttt", "log $result")
            Result.Success(result)
        } catch (e: Exception) {
            Result.Error(exceptionHandler(e))
        }
    }
}