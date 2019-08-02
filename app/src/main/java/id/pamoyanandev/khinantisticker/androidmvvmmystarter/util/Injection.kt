package id.pamoyanandev.khinantisticker.androidmvvmmystarter.util

import android.app.Application
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.data.AppRepository
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.data.source.remote.RemoteDataSource

object Injection {
    fun provideAppRepository(context: Application): AppRepository {
        return AppRepository.getInstance(
            RemoteDataSource(context), RemoteDataSource(context)
            // Change with local data source
        )
    }
}