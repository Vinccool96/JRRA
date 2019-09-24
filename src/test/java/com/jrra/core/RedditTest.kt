package com.jrra.core

import com.jrra.core.http.login.RedditLogin
import io.github.cdimascio.dotenv.Dotenv
import org.junit.Test

import org.junit.Assert.*
import org.junit.BeforeClass

class RedditTest {

    private val dotenv = Dotenv.configure().directory("src/test/res/env/.env").load()

    @Test
    fun getReddit() {
        val redditLogin = RedditLogin(dotenv["CLIENT"]!!, dotenv["REDIRECT_URI"]!!)
        val reddit = Reddit(redditLogin)
    }

}