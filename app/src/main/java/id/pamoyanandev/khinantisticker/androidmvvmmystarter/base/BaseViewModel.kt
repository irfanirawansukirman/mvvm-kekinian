package id.pamoyanandev.khinantisticker.androidmvvmmystarter.base

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.data.AppRepository
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.Injection
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {
    var eventShowProgress = SingleLiveEvent<Boolean>()
    var eventGlobalMessage = SingleLiveEvent<String>()
    var verticalList = ObservableField(0)
    var horizontalList = ObservableField(1)
    val repository: AppRepository by lazy {
        Injection.provideAppRepository(application)
    }

    private val parentJob = Job()
    private val coroutinesContext: CoroutineContext
        get() = parentJob + Dispatchers.IO

    val vmScope = CoroutineScope(coroutinesContext)

    open fun startWork() {}

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

}