package com.jiftun.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jiftun.di.qualifier.AppBaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @AppBaseUrl
    fun provideRetrofit(
        @AppBaseUrl baseUrl: String, okHttpClient: OkHttpClient, factory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient).addConverterFactory(factory)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build()
    }

    @Provides
    fun provideConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }
}