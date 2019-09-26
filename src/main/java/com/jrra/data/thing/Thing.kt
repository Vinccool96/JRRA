package com.jrra.data.thing

import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import com.jrra.core.type.date.DateEpoch
import com.jrra.core.type.date.DateEpochUtc
import com.jrra.data.RedditObject
import java.util.*

abstract class Thing : RedditObject() {

    abstract class Created(@SerializedName(CREATED) @JsonAdapter(DateEpoch::class) val created: Date?,
            @SerializedName(CREATED_UTC) @JsonAdapter(DateEpochUtc::class) val createdUtc: Date?) : Thing() {

        companion object {
            const val CREATED = "created"
            const val CREATED_UTC = "created_utc"
        }
    }

    abstract class Votable(created: Date?, createdUtc: Date?, @SerializedName(UPS) val ups: Int,
            @SerializedName(DOWNS) val downs: Int, @SerializedName(LIKES) val likes: Boolean?) :
            Created(created, createdUtc) {

        companion object {
            const val UPS = "ups"
            const val DOWNS = "downs"
            const val LIKES = "likes"
        }
    }

}