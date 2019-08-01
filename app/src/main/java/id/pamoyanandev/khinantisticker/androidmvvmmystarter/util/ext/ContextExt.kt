package id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.ext

import android.content.Context
import android.content.Intent

/**
 * Using it for moving to another page with activity package name (usually modular package) with params
 *
 * @param activityPackage => exp : id.co.gits.feature_home_detail.HomeDetailActivity
 */
fun Context.navigatorImplicit(
    activityPackage: String,
    intentParams: Intent.() -> Unit
) {
    val intent = Intent()
    try {
        intent.apply {
            intentParams()
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            setClass(
                requireNotNull(applicationContext),
                Class.forName(activityPackage)
            )
        }
        startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    //=========== How to using it ===========
    // navigatorImplicit(yourActivityPackageName) {
    //        putExtra("KEY1" , "VALUE1")
    //        putExtra("KEY2" , "VALUE2")
    //    }
    //=======================================
}

/**
 * Using it for move to another page with clearing existing activity stack
 */
fun Context.navigatorWithActivityClearTop(
    activityPackage: String,
    intentParams: Intent.() -> Unit
) {
    val intent = Intent()
    try {
        intent.apply {
            intentParams()
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            setClass(
                requireNotNull(applicationContext),
                Class.forName(activityPackage)
            )
        }
        startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    //=========== How to using it ===========
    // navigatorWithActivityClearTop<YourActivity>()
    //=======================================
}