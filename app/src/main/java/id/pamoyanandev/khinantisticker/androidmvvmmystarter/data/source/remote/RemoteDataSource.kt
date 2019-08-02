package id.pamoyanandev.khinantisticker.androidmvvmmystarter.data.source.remote

import android.app.Application
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.data.source.AppDataSource

class RemoteDataSource(private val application: Application) : AppDataSource {

    private val apiService: ApiService by lazy {
        ApiService.newBuilder(application, "https://api.themoviedb.org/")
    }

    override suspend fun getMovies() = apiService.getMoviesListAsync()

}