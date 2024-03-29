package id.pamoyanandev.khinantisticker.androidmvvmmystarter.data.source.remote

import android.app.Application
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.BuildConfig
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.data.model.MoviesResponse
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.ext.isNetworkAvailable
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface ApiService {
    @GET("3/discover/movie?api_key=1b2f29d43bf2e4f3142530bc6929d341&sort_by=popularity.desc")
    suspend fun getMoviesListAsync(): MoviesResponse

    companion object Builder {

        fun newBuilder(application: Application, baseUrl: String): ApiService {
            val loggingIntercepter =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val cacheSize = (5 * 1024 * 1024).toLong()
            val appCache = Cache(application.cacheDir, cacheSize)
            val okhttpClient = if (BuildConfig.DEBUG) {
                OkHttpClient.Builder()
                    .cache(appCache)
                    .addInterceptor { chain ->
                        // Get the request from the chain.
                        var request = chain.request()

                        /*
                    *  Leveraging the advantage of using Kotlin,
                    *  we initialize the request and change its header depending on whether
                    *  the device is connected to Internet or not.
                    */
                        request = if (application.isNetworkAvailable(application)!!)
                        /*
                    *  If there is Internet, get the cache that was stored 5 seconds ago.
                    *  If the cache is older than 5 seconds, then discard it,
                    *  and indicate an error in fetching the response.
                    *  The 'max-age' attribute is responsible for this behavior.
                    */
                            request.newBuilder().header(
                                "Cache-Control",
                                "public, max-age=" + 5
                            ).build()
                        else
                        /*
                    *  If there is no Internet, get the cache that was stored 7 days ago.
                    *  If the cache is older than 7 days, then discard it,
                    *  and indicate an error in fetching the response.
                    *  The 'max-stale' attribute is responsible for this behavior.
                    *  The 'only-if-cached' attribute indicates to not retrieve new data; fetch the cache only instead.
                    */
                            request.newBuilder().header(
                                "Cache-Control",
                                "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
                            ).build()
                        // End of if-else statement

                        // Add the modified request to the chain.
                        chain.proceed(request)
                    }
                    .addInterceptor(loggingIntercepter)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build()
            } else {
                OkHttpClient.Builder()
                    .cache(appCache)
                    .addInterceptor { chain ->
                        var request = chain.request()
                        request = if (application.isNetworkAvailable(application)!!)
                            request.newBuilder().header(
                                "Cache-Control",
                                "public, max-age=" + 5
                            ).build()
                        else
                            request.newBuilder().header(
                                "Cache-Control",
                                "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
                            ).build()
                        chain.proceed(request)
                    }
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build()
            }

            val contentType = MediaType.get("application/json")
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(Json.asConverterFactory(contentType))
                .client(okhttpClient)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}