package fluff.logging;

import java.time.format.DateTimeFormatter;

import fluff.logging.handlers.LoggerHandlerConsole;
import fluff.logging.named.NamedLoggerFactory;

public class LogConfig {
	
	public static ILoggerFactory FACTORY = new NamedLoggerFactory();
	
	public static DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
	public static String LOG_FORMAT = "[${time}][${thread} :: ${level}](${name}): ${message}";
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
