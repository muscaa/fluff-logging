package fluff.logging;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a logging level with a name and associated handlers.
 * Instances of this class are used to categorize log messages.
 */
public record LogLevel(String name, List<ILoggerHandler> handlers) {
    
    /** The DEBUG log level. */
    public static final LogLevel DEBUG = new LogLevel("Debug", new ArrayList<>());
    
    /** The INFO log level. */
    public static final LogLevel INFO = new LogLevel("Info", new ArrayList<>());
    
    /** The WARN log level. */
    public static final LogLevel WARN = new LogLevel("Warn", new ArrayList<>());
    
    /** The ERROR log level. */
    public static final LogLevel ERROR = new LogLevel("Error", new ArrayList<>());
    
    /** The CRITICAL log level. */
    public static final LogLevel CRITICAL = new LogLevel("Critical", new ArrayList<>());
}
