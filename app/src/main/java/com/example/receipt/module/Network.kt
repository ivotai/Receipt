package com.example.receipt.module

import com.example.receipt.BaseUrl
import com.example.receipt.BaseUrlImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {



    single {
        OkHttpClient.Builder()
            .readTimeout(30000, TimeUnit.SECONDS)
            .connectTimeout(30000, TimeUnit.SECONDS)
//        .addInterceptor { chain ->
//            if ("login" in chain.request().url.encodedPathSegments || "version" in chain.request().url.encodedPathSegments)
//                chain.proceed(chain.request())
//            else
//                NetworkHelper.proceedRequestWithSession(chain)
//        }
//        .addInterceptor { chain ->
//            val response = chain.proceed(chain.request())
//            if (response.code != 401) return@addInterceptor response
//            // 401 表示 session 过期
//            NetworkHelper.proceedRequestWithNewSession(chain)
//        }
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(get<BaseUrl>().value)
            .client(get())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}
