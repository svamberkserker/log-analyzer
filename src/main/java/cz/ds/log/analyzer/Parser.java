package cz.ds.log.analyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Component
public class Parser {

    private final ObjectMapper objectMapper;

    public Parser(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<LogRecord> parseRecords(Path file) throws IOException {
        List<String> lines = Files.readAllLines(file);
        List<LogRecord> logs = new LinkedList<>();
        for (String line : lines) {
            if (!line.startsWith("{")) {
                continue;
            }

            LogRecord record = objectMapper.readValue(line, LogRecord.class);
            logs.add(record);
        }

        logs.sort(Comparator.comparing(LogRecord::timestamp));

        return logs;
    }
}
