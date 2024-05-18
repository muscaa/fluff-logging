package fluff.logging;

/**
 * Interface representing a logger with methods to log messages at different levels.
 */
public interface ILogger {
	
    /**
     * Logs an object at the specified log level.
     *
     * @param level the log level
     * @param obj   the object to log
     */
    void log(LogLevel level, Object obj);
    
    /**
     * Logs a formatted message at the specified log level.
     *
     * @param level   the log level
     * @param message the message to log
     * @param args    the arguments to format the message
     */
    void log(LogLevel level, String message, Object... args);
    
    /**
     * Logs an exception at the specified log level.
     *
     * @param level the log level
     * @param error the exception to log
     */
    void log(LogLevel level, Throwable error);
    
    /**
     * Logs an object at the DEBUG level.
     *
     * @param obj the object to log
     */
    void debug(Object obj);
    
    /**
     * Logs a formatted message at the DEBUG level.
     *
     * @param message the message to log
     * @param args    the arguments to format the message
     */
    void debug(String message, Object... args);
    
    /**
     * Logs an exception at the DEBUG level.
     *
     * @param error the exception to log
     */
    void debug(Throwable error);
    
    /**
     * Logs an object at the INFO level.
     *
     * @param obj the object to log
     */
    void info(Object obj);
    
    /**
     * Logs a formatted message at the INFO level.
     *
     * @param message the message to log
     * @param args    the arguments to format the message
     */
    void info(String message, Object... args);
    
    /**
     * Logs an exception at the INFO level.
     *
     * @param error the exception to log
     */
    void info(Throwable error);
    
    /**
     * Logs an object at the WARN level.
     *
     * @param obj the object to log
     */
    void warn(Object obj);
    
    /**
     * Logs a formatted message at the WARN level.
     *
     * @param message the message to log
     * @param args    the arguments to format the message
     */
    void warn(String message, Object... args);
    
    /**
     * Logs an exception at the WARN level.
     *
     * @param error the exception to log
     */
    void warn(Throwable error);
    
    /**
     * Logs an object at the ERROR level.
     *
     * @param obj the object to log
     */
    void error(Object obj);
    
    /**
     * Logs a formatted message at the ERROR level.
     *
     * @param message the message to log
     * @param args    the arguments to format the message
     */
    void error(String message, Object... args);
    
    /**
     * Logs an exception at the ERROR level.
     *
     * @param error the exception to log
     */
    void error(Throwable error);
    
    /**
     * Logs an object at the CRITICAL level.
     *
     * @param obj the object to log
     */
    void critical(Object obj);
    
    /**
     * Logs a formatted message at the CRITICAL level.
     *
     * @param message the message to log
     * @param args    the arguments to format the message
     */
    void critical(String message, Object... args);
    
    /**
     * Logs an exception at the CRITICAL level.
     *
     * @param error the exception to log
     */
    void critical(Throwable error);
    
    /**
     * Retrieves the name of the logger.
     *
     * @return the name of the logger
     */
    String getName();
}
