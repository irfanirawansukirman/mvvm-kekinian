package id.pamoyanan_dev.khinantisticker.androidmvvmmystarter

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.crashlytics.android.Crashlytics

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            Crashlytics.getInstance().crash() // Force a crash
        }, 3000)
    }
}
