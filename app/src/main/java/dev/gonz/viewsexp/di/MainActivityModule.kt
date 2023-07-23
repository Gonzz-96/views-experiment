package dev.gonz.viewsexp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dev.gonz.viewsexp.views.MainActivityViewBinder
import dev.gonz.viewsexp.views.MainActivityViewBinderImpl

@Module
@InstallIn(ActivityComponent::class)
interface MainActivityModule {
    @Binds
    fun bindMainActivityViewsFactory(impl: MainActivityViewBinderImpl.Factory): MainActivityViewBinder.Factory
}
