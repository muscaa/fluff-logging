package fluff.logging;

/**
 * Interface representing a handler for logging operations.
 * It defines methods to print log messages at various levels.
 */
public interface ILoggerHandler {
    
    /**
     * Prints a log message with the specified log level and object.
     *
     * @param log the logger instance
     * @param level the log level
     * @param obj the object to log
     */
    void print(ILogger log, LogLevel level, Object obj);
    
    /**
     * Prints a formatted log message with the specified log level.
     *
     * @param log the logger instance
     * @param level the log level
     * @param message the message to log
     * @param args the arguments for the message format
     */
    void print(ILogger log, LogLevel level, String message, Object... args);
    
    /**
     * Prints a log message with the specified log level and throwable.
     *
     * @param log the logger instance
     * @param level the log level
     * @param error the throwable to log
     */
    void print(ILogger log, LogLevel level, Throwable error);
}
