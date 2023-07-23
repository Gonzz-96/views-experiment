package dev.gonz.viewsexp.app

import dagger.Component
import dev.gonz.viewsexp.MainActivity
import dev.gonz.viewsexp.di.MainActivityModule

@Component(modules = [MainActivityModule::class])
interface ViewsExperimentAppComponent {
    fun inject(activity: MainActivity)
}
