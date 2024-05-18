package fluff.logging;

import java.time.format.DateTimeFormatter;

import fluff.logging.handlers.LoggerHandlerConsole;
import fluff.logging.named.NamedLoggerFactory;

/**
 * Configuration class for logging.
 */
public class LogConfig {
	
    /** The logger factory. */
    public static ILoggerFactory FACTORY = new NamedLoggerFactory();
    
    /** The time format for logging timestamps. */
    public static DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    /** The default log format template. */
    public static String LOG_FORMAT = "[${time}][${thread} :: ${level}](${name}): ${message}";
    
    /** The number of stack trace elements to go back when capturing log metadata. */
    public static int TRACE_BACK = 6;
    
    static {
        ILoggerHandler console = new LoggerHandlerConsole();
        
        LogLevel.DEBUG.handlers().add(console);
        LogLevel.INFO.handlers().add(console);
        LogLevel.WARN.handlers().add(console);
        LogLevel.ERROR.handlers().add(console);
        LogLevel.CRITICAL.handlers().add(console);
    }
}
