package com.jrra.core.type.date

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.util.*

class DateEpochUtc : TypeAdapter<Date>() {
    override fun write(writer: JsonWriter?, date: Date?) {
        if (date != null) {
            val time = date.time / 1000
            writer?.value(time.toDouble())
        }
    }

    override fun read(reader: JsonReader?): Date? {
        return if (reader != null) {
            val time = reader.nextDouble().toLong() * 1000
            val date = Date()
            date.time = time
            date
        } else {
            null
        }
    }
}