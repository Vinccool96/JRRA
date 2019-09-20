package com.jrra.core.type

import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import com.jrra.base.util.date.DateUtil
import java.util.*

class DateUnix private constructor() : DateSimple() {

    override fun read(json: JsonReader): Date? {
        val date = read(json, DatePattern.UNIX.value)
        return if (date!=null) DateUtil.dateFromUTC(date) else null
    }

    override fun write(json: JsonWriter, value: Date) {
        write(json, DatePattern.UNIX.value, DateUtil.dateToUTC(value))
    }

}