package fluff.logging.format.parts;

import java.time.LocalDateTime;

import fluff.logging.ILogger;
import fluff.logging.LogConfig;
import fluff.logging.LogLevel;
import fluff.logging.format.ILogFormatPart;

/**
 * Represents a time log format part.
 */
public class LogFormatPartTime implements ILogFormatPart {
    
    @Override
    public String get(ILogger log, LogLevel level, String message) {
        return String.valueOf(LocalDateTime.now().format(LogConfig.TIME_FORMAT));
    }
}
