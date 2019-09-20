package com.jrra.core.type

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.io.IOException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

abstract class DateSimple : TypeAdapter<Date>() {

    fun locale(pattern: String): SimpleDateFormat {
        return SimpleDateFormat(pattern, Locale.getDefault())
    }

    fun read(json: JsonReader, pattern: String): Date? {
        try {
            return locale(pattern).parse(json.nextString())
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return null
    }

    fun write(json: JsonWriter?, pattern: String, value: Date) {
        try {
            json?.value(locale(pattern).format(value))
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}