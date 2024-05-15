package fluff.logging;

import java.io.PrintWriter;
import java.io.StringWriter;

import fluff.logging.utils.StringUtils;

public abstract class AbstractLogger implements ILogger {
	
	// LOG
	
	@Override
	public void log(LogLevel level, Object obj) {
		for (ILoggerHandler lh : level.handlers()) {
			lh.print(this, level, String.valueOf(obj));
		}
	}
	
	@Override
	public void log(LogLevel level, String message, Object... args) {
		log(level, StringUtils.format(message, args));
	}
	
	@Override
	public void log(LogLevel level, Throwable error) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
        error.printStackTrace(pw);
        
		log(level, sw.toString().trim());
	}
	
	// DEBUG
	
	@Override
	public void debug(Object obj) {
		log(LogLevel.DEBUG, obj);
	}
	
	@Override
	public void debug(String message, Object... args) {
		log(LogLevel.DEBUG, message, args);
	}
	
	@Override
	public void debug(Throwable error) {
		log(LogLevel.DEBUG, error);
	}
	
	// INFO
	
	@Override
	public void info(Object obj) {
		log(LogLevel.INFO, obj);
	}
	
	@Override
	public void info(String message, Object... args) {
		log(LogLevel.INFO, message, args);
	}
	
	@Override
	public void info(Throwable error) {
		log(LogLevel.INFO, error);
	}
	
	// WARN
	
	@Override
	public void warn(Object obj) {
		log(LogLevel.WARN, obj);
	}
	
	@Override
	public void warn(String message, Object... args) {
		log(LogLevel.WARN, message, args);
	}
	
	@Override
	public void warn(Throwable error) {
		log(LogLevel.WARN, error);
	}
	
	// ERROR
	
	@Override
	public void error(Object obj) {
		log(LogLevel.ERROR, obj);
	}
	
	@Override
	public void error(String message, Object... args) {
		log(LogLevel.ERROR, message, args);
	}
	
	@Override
	public void error(Throwable error) {
		log(LogLevel.ERROR, error);
	}
	
	// CRITICAL
	
	@Override
	public void critical(Object obj) {
		log(LogLevel.CRITICAL, obj);
	}
	
	@Override
	public void critical(String message, Object... args) {
		log(LogLevel.CRITICAL, message, args);
	}
	
	@Override
	public void critical(Throwable error) {
		log(LogLevel.CRITICAL, error);
	}
}
