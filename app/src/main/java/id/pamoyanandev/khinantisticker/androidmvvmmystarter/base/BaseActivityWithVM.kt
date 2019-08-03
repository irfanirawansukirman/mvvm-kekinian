package id.pamoyanandev.khinantisticker.androidmvvmmystarter.base

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.ext.replaceFragmentInActivity
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.ext.showToast

abstract class BaseActivityWithVM<VDB : ViewDataBinding, BVM : BaseViewModel> :
    AppCompatActivity() {

    lateinit var viewBinding: VDB
    lateinit var baseViewModel: BVM
    lateinit var mActivity: AppCompatActivity

    private var messageType = MESSAGE_SNACK_TYPE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = setContentView(this@BaseActivityWithVM, bindLayoutRes())
        viewBinding.apply {
            mActivity = this@BaseActivityWithVM
            setupToolbar()
            setupViewFragment()
            baseViewModel = onSetViewModel()
            baseViewModel.apply {
                eventGlobalMessage.observe(this@BaseActivityWithVM, Observer { message ->
                    if (message != null) {
                        when (messageType) {
                            MESSAGE_SNACK_TYPE -> {
                                // show snack
                                showToast(message)
                            }
                            else -> {
                                // show toast
                                showToast(message)
                            }
                        }
                    }
                })
            }

            onLoadObserver(baseViewModel)
            onSetInstrument()
            onStartWork()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when {
        item?.itemId == android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> false
    }

    private fun setupToolbar() {
        if (bindToolbarId() != EMPTY_TOOLBAR) {
            setSupportActionBar(findViewById(bindToolbarId()))
            supportActionBar?.apply {
                setDisplayShowTitleEnabled(false)
            }
        }
    }

    private fun setupViewFragment() {
        bindRootFragment()?.let { fragment ->
            bindFragmentContainerId()?.let { containerId ->
                replaceFragmentInActivity(
                    fragment,
                    containerId
                )
            }
        }
    }

    @LayoutRes
    abstract fun bindLayoutRes(): Int

    @IdRes
    abstract fun bindToolbarId(): Int

    abstract fun onSetViewModel(): BVM
    abstract fun onLoadObserver(baseViewModel: BVM)
    abstract fun onStartWork()
    abstract fun onSetInstrument()
    abstract fun bindRootFragment(): Fragment?
    abstract fun bindFragmentContainerId(): Int?

    companion object {
        const val MESSAGE_TOAST_TYPE = 0
        const val MESSAGE_SNACK_TYPE = 1

        const val EMPTY_TOOLBAR = 0
    }

}