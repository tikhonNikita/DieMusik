package com.nikitaTikhonov.diemusik.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideExampleString(): String {
        return "Hello from Dagger!"
    }
}