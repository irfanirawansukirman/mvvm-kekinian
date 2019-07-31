package id.pamoyanandev.khinantisticker.fmovieslist

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.crashlytics.android.Crashlytics
import id.pamoyanan_dev.khinantisticker.f_movies_list.R

class MoviesListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movies_list_activity)

        Handler().postDelayed({

        }, 12345)
    }

    companion object {
        private const val DELAY_THREAD_DEFAULT = 3000.toLong()
    }
}