package id.pamoyanandev.khinantisticker.androidmvvmmystarter

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.NavigationRouteImpl.onMoviesListRoute
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.ext.navigatorImplicit

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        Handler().postDelayed({
            navigatorImplicit(onMoviesListRoute()) {}
        }, 2000)
    }
}
