package com.vit.assessment.domain.model

/**
 * @author vietth
 * @since 07/03/2024
 */
data class Match(
    val date: String?,
    val description: String?,
    val home: Team,
    val away: Team,
    val winner: String?,
    val highlights: String?
)