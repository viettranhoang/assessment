package com.vit.assessment.core.time

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

/**
 * @author vietth
 * @since 11/03/2024
 */
fun convertToReadableDateString(isoString: String?): String {
    if (isoString == null) return ""
    val isoFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
    isoFormatter.timeZone = TimeZone.getTimeZone("UTC")
    val date = isoFormatter.parse(isoString) ?: return ""
    val readableFormat = SimpleDateFormat("MMMM dd, yyyy hh:mm", Locale.ENGLISH)
    return readableFormat.format(date)
}
