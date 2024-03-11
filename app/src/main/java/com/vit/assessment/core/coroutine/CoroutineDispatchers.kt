package com.vit.assessment.core.coroutine

import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author vietth
 * @since 08/03/2024
 */
class CoroutineDispatchers(
    val main: CoroutineDispatcher,
    val mainImmediate: CoroutineDispatcher,
    val io: CoroutineDispatcher,
    val default: CoroutineDispatcher
)