package com.jrra.core.type

import com.google.gson.JsonSyntaxException
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.util.*

class EditedEpochUtc : TypeAdapter<Date>() {
    override fun write(writer: JsonWriter?, date: Date?) {
        if (date != null) {
            val time = date.time / 1000
            writer?.value(time.toDouble())
        }
    }

    override fun read(reader: JsonReader?): Date? {
        val date: Date?
        if (reader != null) {
            val type = reader.peek()
            if (type == JsonToken.BOOLEAN) {
                val edited = reader.nextBoolean()
                if (edited) {
                    date = Date()
                    date.time = 0
                } else {
                    date = null
                }
            } else {
                val nextDouble = reader.nextDouble()
                val time = nextDouble.toLong() * 1000
                date = Date()
                date.time = time
            }
        } else {
            date = null
        }
        return date
    }
}