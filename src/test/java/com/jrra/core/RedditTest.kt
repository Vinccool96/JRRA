package com.jrra.core

import com.jrra.core.http.login.RedditLogin
import org.junit.Test

import org.junit.Assert.*

class RedditTest {

    @Test
    fun getReddit() {
        val redditLogin = RedditLogin("yOZy55j7k6DwPg", "code")
        val reddit = Reddit(redditLogin)
    }

}