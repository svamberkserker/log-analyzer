package cz.ds.log.analyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class LogAnalyzerApplication {

    public static void main(String[] args) throws IOException {
        try (ConfigurableApplicationContext context = SpringApplication.run(LogAnalyzerApplication.class, args)) {
            Parser parser = context.getBean(Parser.class);
            List<LogRecord> logs = parser.parseRecords(Path.of(args[0]));

            try (FileOutputStream out = new FileOutputStream("analyzed-" + LocalDateTime.now() + ".log");
                 OutputStreamWriter writer = new OutputStreamWriter(out)) {
                for (LogRecord log : logs) {
                    String formatted = MessageFormat.format("{0} {1} [{2}] - {3}\n",
                            log.timestamp(),
                            log.level(),
                            log.threadName(),
                            log.message());
//                    System.out.println(formatted);
                    writer.write(formatted);
                }
            }
        }
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().findAndRegisterModules();
    }
}
