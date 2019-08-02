package id.pamoyanandev.khinantisticker.androidmvvmmystarter.data

import id.pamoyanandev.khinantisticker.androidmvvmmystarter.data.model.MoviesResponse
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.data.source.AppDataSource
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.data.source.remote.RemoteDataSource

class AppRepository(
    private val remoteDataSource: AppDataSource,
    private val localDataSource: AppDataSource
) : AppDataSource {

    override suspend fun getMovies(): MoviesResponse {
        return remoteDataSource.getMovies()
    }

    companion object {
        var mRepository: AppRepository? = null

        @JvmStatic
        fun getInstance(
            dataRemoteSource: RemoteDataSource,
            dataLocalSource: RemoteDataSource
        ): AppRepository {
            if (mRepository == null) {
                mRepository = AppRepository(
                    remoteDataSource = dataRemoteSource,
                    localDataSource = dataLocalSource
                )
            }
            return mRepository!!
        }
    }

}