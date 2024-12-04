package com.nikitaTikhonov.diemusik

import android.app.Application
import com.nikitaTikhonov.diemusik.di.AppComponent
import com.nikitaTikhonov.diemusik.di.DaggerAppComponent


class DieMusikApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.create()
    }
}