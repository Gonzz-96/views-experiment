package dev.gonz.viewsexp.views

import android.view.View
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dev.gonz.viewsexp.databinding.ActivityMainBinding

interface MainActivityViews {
    val root: View

    interface Factory {
        fun create(binding: ActivityMainBinding): MainActivityViews
    }
}

class MainActivityViewsImpl @AssistedInject constructor(
    @Assisted private val binding: ActivityMainBinding,
) : MainActivityViews {

    override val root = binding.root

    @AssistedFactory
    interface Factory : MainActivityViews.Factory {
        override fun create(binding: ActivityMainBinding): MainActivityViewsImpl
    }
}
