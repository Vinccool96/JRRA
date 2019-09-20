package com.jrra.core

import com.google.gson.GsonBuilder
import com.jrra.arch.http.HttpBuilder
import com.jrra.arch.http.HttpClient
import com.jrra.core.http.login.RedditLogin
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Reddit() : Callback<ResponseBody> {

    val reddit: HttpClient

    init {
        val gSon = GsonBuilder().setLenient().create()
        reddit = Retrofit.Builder().client(HttpBuilder().make()).baseUrl(REDDIT_API)
                .addConverterFactory(GsonConverterFactory.create(gSon)).build().create(HttpClient::class.java)
    }

    public constructor(redditLogin: RedditLogin) : this() {
        val r = reddit.login(redditLogin.clientId, redditLogin.responseType, redditLogin.state, redditLogin.redirectUri,
                redditLogin.duration.urlString, redditLogin.scope)
        r.enqueue(this)
    }

    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
        println(call)
        println(t)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
        println(call)
        println(response)
        val body = response.body()
        println(body)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        private const val REDDIT_API = "https://www.reddit.com"
    }
}