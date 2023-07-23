package dev.gonz.viewsexp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dev.gonz.viewsexp.views.MainActivityViews
import dev.gonz.viewsexp.views.MainActivityViewsImpl

@Module
@InstallIn(ActivityComponent::class)
interface MainActivityModule {
    @Binds
    fun bindMainActivityViewsFactory(impl: MainActivityViewsImpl.Factory): MainActivityViews.Factory
}
