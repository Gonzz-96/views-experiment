package dev.gonz.viewsexp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import dev.gonz.viewsexp.databinding.ActivityMainBinding
import dev.gonz.viewsexp.views.MainActivityViews
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewsFactory: MainActivityViews.Factory

    private lateinit var views: MainActivityViews

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityMainBinding.inflate(layoutInflater).run(viewsFactory::create)
        setContentView(views.root)
    }
}
