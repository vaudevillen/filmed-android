package joshshin.me.filmed.network

import joshshin.me.filmed.BuildConfig
import joshshin.me.filmed.FilmedConstants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Josh Shin on 4/15/18
 */

internal object FilmedApi {
    private val loggingInterceptor =
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            }

    private val client by lazy {
        if (BuildConfig.DEBUG) {
            OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build()
        } else {
            OkHttpClient()
        }
    }

    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    inline fun <reified S> createService(): S {
        return retrofit.create(S::class.java)
    }
}