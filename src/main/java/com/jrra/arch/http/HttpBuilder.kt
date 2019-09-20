package com.jrra.arch.http

import okhttp3.Interceptor
import okhttp3.OkHttpClient

class HttpBuilder {
    fun make(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor { chain ->
            val httpUrl = chain.request().url
            val pathSegments = httpUrl.pathSegments
            val lastPathSegment = pathSegments.last()
            val pathSegment = "$lastPathSegment.json"
            chain.proceed(chain.request().newBuilder().url(httpUrl.newBuilder().setPathSegment(pathSegments.lastIndex, pathSegment).build()).build())
        }.build()
    }
}