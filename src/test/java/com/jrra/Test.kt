package com.jrra

import com.jrra.core.Reddit
import com.jrra.core.http.login.RedditLogin

fun main(args: Array<String>) {
    val redditLogin = RedditLogin("yOZy55j7k6DwPg", "code")
    val reddit = Reddit(redditLogin)
}