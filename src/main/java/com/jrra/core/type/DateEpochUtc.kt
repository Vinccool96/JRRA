package com.jrra.core.type

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.util.*

class DateEpochUtc : TypeAdapter<Date>() {
    override fun write(writer: JsonWriter?, date: Date?) {
        if (date!=null){
            val time = date.time
            writer?.value(time.toDouble())
        }
    }

    override fun read(reader: JsonReader?): Date? {
        return if (reader!=null){
            val time = reader.nextDouble().toLong()
            val date = Date()
            date.time = time
            date
        } else {
            null
        }
    }
}