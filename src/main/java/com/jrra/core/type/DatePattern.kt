package com.jrra.core.type

enum class DatePattern(val value: String) {
    COMMON("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"),
    DAY("yyyy-MM-dd"),
    UNIX("yyyy-MM-dd'T'HH:mm:ss'Z'")
}