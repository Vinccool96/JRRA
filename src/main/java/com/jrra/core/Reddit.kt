package com.jrra.core

import com.google.gson.Gson
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

class Reddit(redditLogin: RedditLogin) : Callback<List<Base>> {

    val reddit: HttpClient

    val state: String

    init {
        reddit = Retrofit.Builder().client(HttpBuilder().make()).baseUrl(REDDIT_API)
                .addConverterFactory(GsonConverterFactory.create(gSon)).build().create(HttpClient::class.java)
        state = redditLogin.state
//        val r = reddit.login(redditLogin.clientId, redditLogin.responseType, redditLogin.state, redditLogin.redirectUri,
//                redditLogin.duration.urlString, redditLogin.scope)
//        r.enqueue(this)
        val r = reddit.test().enqueue(this)
    }

    override fun onFailure(call: Call<List<Base>>, t: Throwable) {
        println(call)
        throw t
    }

    override fun onResponse(call: Call<List<Base>>, response: Response<List<Base>>) {
        println(call)
        println(response)
        val body = response.body()
        println(body)
    }

    companion object {
        val adapter: RedditTypeAdapter<Base> = RedditTypeAdapter.of(Base::class.java, KIND)
                .registerSubtype(Base.BaseAccount::class.java, RedditTypes.ACCOUNT.type)
                .registerSubtype(Base.BaseAward::class.java, RedditTypes.AWARD.type)
                .registerSubtype(Base.BaseComment::class.java, RedditTypes.COMMENT.type)
                .registerSubtype(Base.BaseLink::class.java, RedditTypes.LINK.type)
                .registerSubtype(Base.BaseListing::class.java, RedditTypes.LISTING.type)
                .registerSubtype(Base.BaseMessage::class.java, RedditTypes.MESSAGE.type)
                .registerSubtype(Base.BaseSubreddit::class.java, RedditTypes.SUBREDDIT.type)
        val gSon: Gson = GsonBuilder().setLenient().registerTypeAdapterFactory(adapter).create()
        private const val REDDIT_API = "http://127.0.0.1:8000"
        //private const val REDDIT_API = "https://www.reddit.com"
    }
}