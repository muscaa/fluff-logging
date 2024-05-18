package fluff.logging;

/**
 * Interface representing a factory for creating loggers.
 */
public interface ILoggerFactory {
	
    /**
     * Creates a logger with the specified name.
     *
     * @param name the name of the logger
     * @return the created logger
     */
    ILogger create(String name);
    
    /**
     * Creates a logger for the specified class.
     *
     * @param clazz the class for which to create a logger
     * @return the created logger
     */
    ILogger create(Class<?> clazz);
}
