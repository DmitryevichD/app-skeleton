package by.dm13y.app.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import mu.KotlinLogging
import org.slf4j.MDC

object CommonUtils {
    private val log = KotlinLogging.logger {}
    private val objectMapper = ObjectMapper()
        .also { it.enable(SerializationFeature.INDENT_OUTPUT) }
        .also { it.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false) }
        .also { it.registerModule(JavaTimeModule()) }

    fun Any.toPretty(): String =
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this)
        } catch (ex: Exception) {
            this.toString().also { log.warn { "Fail build pretty json for $it. Error: ${ex.message}" } }
        }

    fun String.mdcContext(): String =
        MDC.getCopyOfContextMap()?.let { "$this. Context: $it" } ?: this
}