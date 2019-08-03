package id.pamoyanandev.khinantisticker.fmovieslist

import android.app.Application
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.base.BaseViewModel
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.data.model.Result
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesListVM(_application: Application) : BaseViewModel(_application) {

    val moviesList = SingleLiveEvent<List<Result>>()

    init {
        vmScope.launch {
            eventShowProgress.postValue(true)
            val response = repository.getMovies()

            withContext(Dispatchers.Main) {
                response.results?.let {
                    eventShowProgress.value = false
                    moviesList.value = it
                }
            }
        }
    }
}