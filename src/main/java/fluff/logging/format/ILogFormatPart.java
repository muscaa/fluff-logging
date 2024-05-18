package fluff.logging.format;

import fluff.logging.ILogger;
import fluff.logging.LogLevel;

/**
 * Represents a part of the log format.
 */
public interface ILogFormatPart {
    
    /**
     * Retrieves the formatted log part.
     *
     * @param log     the logger
     * @param level   the log level
     * @param message the log message
     * @return the formatted log part
     */
    String get(ILogger log, LogLevel level, String message);
}
