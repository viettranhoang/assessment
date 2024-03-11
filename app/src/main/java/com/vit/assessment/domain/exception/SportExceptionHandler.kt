package com.vit.assessment.domain.exception

import javax.inject.Inject

/**
 * @author vietth
 * @since 09/03/2024
 */
interface SportExceptionHandler {
    operator fun invoke(e: Exception): Exception
}

class SportExceptionHandlerImpl @Inject constructor() : SportExceptionHandler {

    override fun invoke(e: Exception): Exception {
        return e
    }
}



