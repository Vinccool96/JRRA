package com.jrra.core

import com.google.gson.GsonBuilder
import com.jrra.arch.http.HttpBuilder
import com.jrra.arch.http.HttpClient
import com.jrra.base.gson.RedditTypeAdapter
import com.jrra.core.http.login.RedditLogin
import com.jrra.data.Base
import com.jrra.data.Base.Companion.KIND
import com.jrra.data.RedditTypes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Reddit(redditLogin: RedditLogin) : Callback<Base> {

    val reddit: HttpClient

    val state: String

    init {
        val typeAdapter = RedditTypeAdapter.of(Base::class.java, KIND)
                .registerSubtype(Base.BaseAccount::class.java, RedditTypes.ACCOUNT.type)
                .registerSubtype(Base.BaseAward::class.java, RedditTypes.AWARD.type)
                .registerSubtype(Base.BaseComment::class.java, RedditTypes.COMMENT.type)
                .registerSubtype(Base.BaseLink::class.java, RedditTypes.LINK.type)
                .registerSubtype(Base.BaseListing::class.java, RedditTypes.LISTING.type)
                .registerSubtype(Base.BaseMessage::class.java, RedditTypes.MESSAGE.type)
                .registerSubtype(Base.BaseSubreddit::class.java, RedditTypes.SUBREDDIT.type)
        val gSon = GsonBuilder().setLenient().registerTypeAdapterFactory(typeAdapter).create()
        reddit = Retrofit.Builder().client(HttpBuilder().make()).baseUrl(REDDIT_API)
                .addConverterFactory(GsonConverterFactory.create(gSon)).build().create(HttpClient::class.java)
        state = redditLogin.state
//        val r = reddit.login(redditLogin.clientId, redditLogin.responseType, redditLogin.state, redditLogin.redirectUri,
//                redditLogin.duration.urlString, redditLogin.scope)
//        r.enqueue(this)
        val r = reddit.test().enqueue(this)
    }

    override fun onFailure(call: Call<Base>, t: Throwable) {
        println(call)
        println(t)
    }

    override fun onResponse(call: Call<Base>, response: Response<Base>) {
        println(call)
        println(response)
        val body = response.body()
        println(body)
    }

    companion object {
        // private const val REDDIT_API = "http://127.0.0.1:8000"
        private const val REDDIT_API = "https://www.reddit.com"
    }
}