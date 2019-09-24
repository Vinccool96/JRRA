package com.jrra.data.listing

import com.google.gson.annotations.SerializedName
import com.jrra.data.Base
import com.jrra.data.RedditObject

class Listing(@SerializedName(BEFORE) val before: String?, @SerializedName(AFTER) val after: String?,
        @SerializedName(MODHASH) val modhash: String, @SerializedName(CHILDREN) val children: List<Base>) :
        RedditObject() {

    companion object {
        const val BEFORE = "before"
        const val AFTER = "after"
        const val MODHASH = "modhash"
        const val CHILDREN = "children"
    }
}