package dev.gonz.viewsexp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import dev.gonz.viewsexp.databinding.ActivityMainBinding
import dev.gonz.viewsexp.views.MainActivityViewBinder
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewBinderFactory: MainActivityViewBinder.Factory

    private lateinit var viewBinder: MainActivityViewBinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinder = ActivityMainBinding.inflate(layoutInflater).run(viewBinderFactory::create)
        setContentView(viewBinder.root)
    }
}
