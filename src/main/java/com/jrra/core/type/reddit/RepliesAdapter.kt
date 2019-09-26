package com.jrra.core.type.reddit

import com.google.gson.TypeAdapter
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import com.jrra.core.Reddit
import com.jrra.data.Base

class RepliesAdapter : TypeAdapter<Base>() {

    override fun write(writer: JsonWriter?, value: Base?) {
        if (writer != null && value != null) {
            val adapter = Reddit.gSon.getAdapter(object : TypeToken<Base>() {})
            adapter.write(writer, value)
        }
    }

    override fun read(reader: JsonReader?): Base? {
        val result: Base?
        result = if (reader != null) {
            val peek = reader.peek()
            if (peek == JsonToken.STRING) {
                reader.skipValue()
                null
            } else {
                val adapter = Reddit.gSon.getAdapter(object : TypeToken<Base>() {})
                adapter.read(reader)
            }
        } else {
            null
        }
        return result
    }
}