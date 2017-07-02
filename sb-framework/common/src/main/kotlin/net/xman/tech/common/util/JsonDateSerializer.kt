package net.xman.tech.common.util

import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider

class JsonDateSerializer : JsonSerializer<Date>() {

    @Throws(IOException::class, JsonProcessingException::class)
    override fun serialize(date: Date, gen: JsonGenerator, provider: SerializerProvider) {
        val formattedDate = dateFormat.format(date)
        gen.writeString(formattedDate)
    }

    companion object {
        private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    }

}
