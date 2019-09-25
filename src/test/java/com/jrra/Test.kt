package com.jrra

import com.jrra.core.Reddit
import com.jrra.core.http.login.RedditLogin
import io.github.cdimascio.dotenv.Dotenv

fun main(args: Array<String>) {
    val dotenv = Dotenv.configure().directory("src/test/res/env/.env").load()
    val redditLogin = RedditLogin(dotenv["CLIENT"]!!, dotenv["REDIRECT_URI"]!!)
    val reddit = Reddit(redditLogin)
}