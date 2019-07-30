package id.pamoyanan_dev.khinantisticker.androidmvvmmystarter

import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        /**
         * Firebase (fabric.io) crash monitor config.
         * Active when debug mode only
         */
        if (BuildConfig.DEBUG) {
            /**
             * reference : [
             * 1: https://firebase.google.com/docs/crashlytics/get-started-android?hl=id,
             * 2: https://firebase.google.com/docs/crashlytics/get-started?platform=android
             * ]
             */
            Fabric.with(this, Crashlytics())
        }
    }
}