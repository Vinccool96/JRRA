package com.jrra.arch.bind

import com.jrra.arch.http.HttpBuilder
import com.jrra.arch.http.HttpClient
import com.jrra.arch.user.SelfShared
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


internal class BindBackend {

    fun provideBuilder(factory: Converter.Factory): Retrofit.Builder {
        return Retrofit.Builder().client(HttpBuilder().make()).addConverterFactory(factory)
    }

    fun provideClient(retrofitBuilder: Retrofit.Builder): HttpClient {
        return retrofitBuilder.baseUrl(REDDIT_API).build().create(HttpClient::class.java)
    }

    fun provideConverter(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    companion object {
        private const val REDDIT_API = "https://old.reddit.com"
    }
}