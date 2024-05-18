package fluff.logging;

import fluff.logging.format.LogFormat;

/**
 * Static class for creating loggers and defining log format.
 */
public class Log {
	
    /** The log format used for formatting log messages. */
    public static final LogFormat FORMAT = LogFormat.compile();
    
    /**
     * Creates a logger with the specified name.
     * @param name The name of the logger.
     * @return The created logger.
     */
    public static ILogger create(String name) {
        return LogConfig.FACTORY.create(name);
    }
    
    /**
     * Creates a logger for the specified class.
     * @param clazz The class for which the logger is created.
     * @return The created logger.
     */
    public static ILogger create(Class<?> clazz) {
        return LogConfig.FACTORY.create(clazz);
    }
}
