package com.nikitaTikhonov.diemusik.di

import com.nikitaTikhonov.diemusik.ui.MainFragment
import com.nikitaTikhonov.diemusik.ui.OnboardingFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, OnboardingModule::class])
interface AppComponent {
    fun inject(fragment: MainFragment)
    fun inject(onboardingFragment: OnboardingFragment) // Add the new fragment injection

}