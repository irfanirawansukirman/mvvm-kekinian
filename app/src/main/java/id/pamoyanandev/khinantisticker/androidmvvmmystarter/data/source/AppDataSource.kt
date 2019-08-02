package id.pamoyanandev.khinantisticker.androidmvvmmystarter.data.source

import id.pamoyanandev.khinantisticker.androidmvvmmystarter.data.model.MoviesResponse

interface AppDataSource {
    suspend fun getMovies(): MoviesResponse
}