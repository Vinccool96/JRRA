package com.jrra.data.link

import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import com.jrra.core.type.EditedEpochUtx
import com.jrra.data.thing.Thing
import java.util.*

class Link(created: Date?, createdUtc: Date?, ups: Int, downs: Int, likes: Boolean?,
        @SerializedName(AUTHOR) val author: String?,
        @SerializedName(AUTHOR_FLAIR_CSS_CLASS) val authorFlairCssClass: String?,
        @SerializedName(AUTHOR_FLAIR_TEXT) val authorFlairText: String?, @SerializedName(CLICKED) val clicked: Boolean,
        @SerializedName(DOMAIN) val domain: String, @SerializedName(HIDDEN) val hidden: Boolean,
        @SerializedName(IS_SELF) val isSelf: Boolean,
        @SerializedName(LINK_FLAIR_CSS_CLASS) val linkFlairCssClass: String?,
        @SerializedName(LINK_FLAIR_TEXT) val linkFlairText: String?, @SerializedName(LOCKED) val locked: Boolean,
        @SerializedName(MEDIA) val media: Any, @SerializedName(MEDIA_EMBED) val mediaEmbed: Any,
        @SerializedName(NUM_COMMENTS) val numComments: Int, @SerializedName(OVER_18) val over18: Boolean,
        @SerializedName(PERMALINK) val permalink: String, @SerializedName(SAVED) val saved: Boolean,
        @SerializedName(SCORE) val score: Int, @SerializedName(SELFTEXT) val selftext: String,
        @SerializedName(SELFTEXT_HTML) val selftextHtml: String, @SerializedName(SUBREDDIT) val subreddit: String,
        @SerializedName(SUBREDDIT_ID) val subredditId: String, @SerializedName(THUMBNAIL) val thumbnail: String,
        @SerializedName(TITLE) val title: String, @SerializedName(URL) val url: String,
        @SerializedName(EDITED) @JsonAdapter(EditedEpochUtx::class) val edited: Date?,
        @SerializedName(DISTINGUISHED) val distinguished: String?, @SerializedName(STICKIED) val stickied: Boolean) :
        Thing.Votable(created, createdUtc, ups, downs, likes) {

    companion object {
        const val AUTHOR = "author"
        const val AUTHOR_FLAIR_CSS_CLASS = "author_flair_css_class"
        const val AUTHOR_FLAIR_TEXT = "author_flair_text"
        const val CLICKED = "clicked"
        const val DOMAIN = "domain"
        const val HIDDEN = "hidden"
        const val IS_SELF = "is_self"
        const val LINK_FLAIR_CSS_CLASS = "link_flair_css_class"
        const val LINK_FLAIR_TEXT = "link_flair_text"
        const val LOCKED = "locked"
        const val MEDIA = "media"
        const val MEDIA_EMBED = "media_embed"
        const val NUM_COMMENTS = "num_comments"
        const val OVER_18 = "over_18"
        const val PERMALINK = "permalink"
        const val SAVED = "saved"
        const val SCORE = "score"
        const val SELFTEXT = "selftext"
        const val SELFTEXT_HTML = "selftext_html"
        const val SUBREDDIT = "subreddit"
        const val SUBREDDIT_ID = "subreddit_id"
        const val THUMBNAIL = "thumbnail"
        const val TITLE = "title"
        const val URL = "url"
        const val EDITED = "edited"
        const val DISTINGUISHED = "distinguished"
        const val STICKIED = "stickied"
    }
}