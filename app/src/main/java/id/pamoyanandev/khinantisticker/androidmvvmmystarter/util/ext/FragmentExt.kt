package id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.ext

import android.os.Bundle
import androidx.fragment.app.Fragment

inline fun <FRAGMENT : Fragment> FRAGMENT.putArgs(argsBuilder: Bundle.() -> Unit):
        FRAGMENT = this.apply { arguments = Bundle().apply(argsBuilder) }