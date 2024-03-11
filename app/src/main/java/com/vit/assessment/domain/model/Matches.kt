package com.vit.assessment.domain.model

/**
 * @author vietth
 * @since 07/03/2024
 */
data class Matches(
    val previous: List<Match>,
    val upcoming: List<Match>
)
