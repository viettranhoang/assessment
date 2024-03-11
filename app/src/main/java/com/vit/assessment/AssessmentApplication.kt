package com.vit.assessment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * @author vietth
 * @since 09/03/2024
 */
@HiltAndroidApp
class AssessmentApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}