package id.pamoyanandev.khinantisticker.fmovieslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import id.pamoyanan_dev.khinantisticker.f_movies_list.R
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.App
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.ext.getViewModel
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.ext.showToast

class MoviesListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movies_list_activity)

        val vm = getViewModel { MoviesListVM(App.instance) }
        vm.apply {
            message.observe(this@MoviesListActivity, Observer {
                showToast(it)
            })
        }
    }

    companion object {
        private const val DELAY_THREAD_DEFAULT = 3000.toLong()
    }
}