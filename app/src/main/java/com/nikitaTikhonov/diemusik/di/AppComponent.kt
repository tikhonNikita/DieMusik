package com.nikitaTikhonov.diemusik.di

import com.nikitaTikhonov.diemusik.ui.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(fragment: MainFragment)
}