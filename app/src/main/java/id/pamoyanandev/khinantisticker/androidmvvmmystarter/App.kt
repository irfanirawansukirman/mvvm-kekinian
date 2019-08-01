package id.pamoyanandev.khinantisticker.androidmvvmmystarter

import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        // firebase (fabric.io) crash monitor config.
        // active when debug mode only
        if (BuildConfig.DEBUG) {
            // reference : [
            // 1: https://firebase.google.com/docs/crashlytics/get-started-android?hl=id,
            // 2: https://firebase.google.com/docs/crashlytics/get-started?platform=android
            // ]
            Fabric.with(this, Crashlytics())
        }

        /**
         * leak canary for detect leak memory in application.
         * reference: [
         * 1: https://developpaper.com/android-memory-leak-location-analysis-and-solution/
         * ]
         */
        // if (LeakCanary.isInAnalyzerProcess(this)) {
        // This process is dedicated to LeakCanary for heap analysis.
        // You should not init your app in this process.
        // return
        // }
        // LeakCanary.install(this)
        // Normal app init code...
    }
}