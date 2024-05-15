package fluff.logging.handlers;

import fluff.logging.ILogger;
import fluff.logging.ILoggerHandler;
import fluff.logging.Log;
import fluff.logging.LogLevel;

public class LoggerHandlerConsole implements ILoggerHandler {
	
	@Override
	public void print(ILogger log, LogLevel level, String message) {
		System.out.println(Log.FORMAT.get(log, level, message));
	}
}
