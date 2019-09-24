package com.jrra.core.http.login

import com.jrra.base.util.random.RandomUtil

class RedditLogin(val clientId: String, val redirectUri: String, val responseType: String = "code",
                  val duration: RedditLoginDuration = RedditLoginDuration.PERMANENT) {

    val state: String

    val scope: String
        get() {
            return "edit flair history modconfig modflair modlog modposts modwiki mysubreddits privatemessages read report save submit subscribe vote wikiedit wikiread"
        }

    init {
        state = RandomUtil.randomString(16)
    }

}