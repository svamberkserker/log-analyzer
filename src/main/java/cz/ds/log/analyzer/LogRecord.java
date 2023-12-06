package cz.ds.log.analyzer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public record LogRecord(
        @JsonProperty("mdc") MdcData mdc,
        @JsonProperty("exception_class") String exceptionClass,
        @JsonProperty("exception_message") String exceptionMessage,
        @JsonProperty("stacktrace") String stackTrace,
        @JsonProperty("@version") int version,
        @JsonProperty("source_host") String sourceHost,
        @JsonProperty("message") String message,
        @JsonProperty("thread_name") String threadName,
        @JsonProperty("@timestamp") ZonedDateTime timestamp,
        @JsonProperty("level") String level,
        @JsonProperty("logger_name") String loggerName
) {
}
