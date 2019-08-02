package id.pamoyanandev.khinantisticker.fmovieslist

import android.app.Application
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.base.BaseViewModel
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.SingleLiveEvent
import kotlinx.coroutines.launch

class MoviesListVM(_application: Application) : BaseViewModel(_application) {

    val message = SingleLiveEvent<String>()

    init {
        coroutinesScope.launch {
            message.postValue(repository.getMovies().results?.get(0)?.original_title)
        }
    }

}