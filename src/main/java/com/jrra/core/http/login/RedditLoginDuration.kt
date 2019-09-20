package com.jrra.core.http.login

enum class RedditLoginDuration(val urlString: String) {
    TEMPORARY("temporary"),
    PERMANENT("permanent")
}