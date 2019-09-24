package com.jrra.data

import com.google.gson.annotations.SerializedName
import com.jrra.data.account.Account
import com.jrra.data.award.Award
import com.jrra.data.comment.Comment
import com.jrra.data.link.Link
import com.jrra.data.listing.Listing
import com.jrra.data.message.Message
import com.jrra.data.subreddit.Subreddit

abstract class Base(@SerializedName(KIND) val kind: String) {

    class BaseAccount(type: String, @SerializedName(DATA) val data: Account) : Base(type) {
    }


    class BaseAward(type: String, @SerializedName(DATA) val data: Award) : Base(type) {
    }


    class BaseComment(type: String, @SerializedName(DATA) val data: Comment) : Base(type) {
    }


    class BaseLink(type: String, @SerializedName(DATA) val data: Link) : Base(type) {
    }


    class BaseListing(type: String, @SerializedName(DATA) val data: Listing) : Base(type) {
    }


    class BaseMessage(type: String, @SerializedName(DATA) val data: Message) : Base(type) {
    }


    class BaseSubreddit(type: String, @SerializedName(DATA) val data: Subreddit) : Base(type) {
    }

    companion object {
        const val KIND = "kind"
        const val DATA = "data"
    }
}