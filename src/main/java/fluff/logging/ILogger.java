package fluff.logging;

public interface ILogger {
	
	// LOG
	
	void log(LogLevel level, Object obj);
	
	void log(LogLevel level, String message, Object... args);
	
	void log(LogLevel level, Throwable error);
	
	// DEBUG
	
	void debug(Object obj);
	
	void debug(String message, Object... args);
	
	void debug(Throwable error);
	
	// INFO
	
	void info(Object obj);
	
	void info(String message, Object... args);
	
	void info(Throwable error);
	
	// WARN
	
	void warn(Object obj);
	
	void warn(String message, Object... args);
	
	void warn(Throwable error);
	
	// ERROR
	
	void error(Object obj);
	
	void error(String message, Object... args);
	
	void error(Throwable error);
	
	// CRITICAL
	
	void critical(Object obj);
	
	void critical(String message, Object... args);
	
	void critical(Throwable error);
	
	// Other
	String getName();
}
