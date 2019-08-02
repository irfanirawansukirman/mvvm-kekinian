package id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.ext

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.base.BaseViewModelFactory

fun AppCompatActivity.replaceFragmentInActivity(
    fragment: Fragment,
    frameId: Int
) {
    supportFragmentManager.transact {
        replace(frameId, fragment)
    }
}

private inline fun FragmentManager.transact(
    action: FragmentTransaction.() -> Unit
) {
    beginTransaction().apply {
        action()
    }.commit()
}

inline fun <reified T : ViewModel> AppCompatActivity.getViewModel(noinline creator: (() -> T)? = null): T {
    return if (creator == null)
        ViewModelProviders.of(this).get(T::class.java)
    else
        ViewModelProviders.of(this, BaseViewModelFactory(creator)).get(T::class.java)
}