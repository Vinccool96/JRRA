package com.jrra.data.comment

import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import com.jrra.core.type.EditedEpochUtc
import com.jrra.data.Base
import com.jrra.data.thing.Thing
import java.util.*

class Comment(created: Date?, createdUtc: Date?, ups: Int, downs: Int, likes: Boolean?,
        @SerializedName(APPROVED_BY) val approvedBy: String?, @SerializedName(AUTHOR) val author: String,
        @SerializedName(AUTHOR_FLAIR_CSS_CLASS) val authorFlairCssClass: String?,
        @SerializedName(AUTHOR_FLAIR_TEXT) val authorFlairText: String?,
        @SerializedName(BANNED_BY) val bannedBy: String?, @SerializedName(BODY) val body: String,
        @SerializedName(BODY_HTML) val bodyHtml: String,
        @SerializedName(EDITED) @JsonAdapter(EditedEpochUtc::class) val edited: Date?,
        @SerializedName(GILDED) val gilded: Int, @SerializedName(LINK_AUTHOR) val linkAuthor: String,
        @SerializedName(LINK_ID) val linkId: String, @SerializedName(LINK_TITLE) val linkTitle: String,
        @SerializedName(LINK_URL) val linkUrl: String, @SerializedName(NUM_REPORTS) val numReports: Int?,
        @SerializedName(PARENT_ID) val parentId: String, @SerializedName(REPLIES) val replies: List<Base>,
        @SerializedName(SAVED) val saved: Boolean, @SerializedName(SCORE) val score: Int,
        @SerializedName(SCORE_HIDDEN) val scoreHidden: Boolean, @SerializedName(SUBREDDIT) val subreddit: String,
        @SerializedName(SUBREDDIT_ID) val subredditId: String,
        @SerializedName(DISTINGUISHED) val distinguished: String?) :
        Thing.Votable(created, createdUtc, ups, downs, likes) {

    companion object {
        const val APPROVED_BY = "approved_by"
        const val AUTHOR = "author"
        const val AUTHOR_FLAIR_CSS_CLASS = "author_flair_css_class"
        const val AUTHOR_FLAIR_TEXT = "author_flair_text"
        const val BANNED_BY = "banned_by"
        const val BODY = "body"
        const val BODY_HTML = "body_html"
        const val EDITED = "edited"
        const val GILDED = "gilded"
        const val LINK_AUTHOR = "link_author"
        const val LINK_ID = "link_id"
        const val LINK_TITLE = "link_title"
        const val LINK_URL = "link_url"
        const val NUM_REPORTS = "num_reports"
        const val PARENT_ID = "parent_id"
        const val REPLIES = "replies"
        const val SAVED = "saved"
        const val SCORE = "score"
        const val SCORE_HIDDEN = "score_hidden"
        const val SUBREDDIT = "subreddit"
        const val SUBREDDIT_ID = "subreddit_id"
        const val DISTINGUISHED = "distinguished"
    }

}