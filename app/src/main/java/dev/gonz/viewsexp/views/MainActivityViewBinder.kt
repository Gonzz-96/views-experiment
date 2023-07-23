package dev.gonz.viewsexp.views

import android.view.View
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dev.gonz.viewsexp.databinding.ActivityMainBinding

interface MainActivityViewBinder {
    val root: View

    interface Factory {
        fun create(binding: ActivityMainBinding): MainActivityViewBinder
    }
}

class MainActivityViewBinderImpl @AssistedInject constructor(
    @Assisted private val binding: ActivityMainBinding,
) : MainActivityViewBinder {

    override val root = binding.root

    @AssistedFactory
    interface Factory : MainActivityViewBinder.Factory {
        override fun create(binding: ActivityMainBinding): MainActivityViewBinderImpl
    }
}
