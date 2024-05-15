package fluff.logging.handlers;

import java.io.IOException;
import java.io.Writer;

import fluff.logging.ILogger;
import fluff.logging.ILoggerHandler;
import fluff.logging.Log;
import fluff.logging.LogLevel;

public class LoggerHandlerWriter implements ILoggerHandler {
	
	private final Writer writer;
	
	public LoggerHandlerWriter(Writer writer) {
		this.writer = writer;
	}
	
	@Override
	public void print(ILogger log, LogLevel level, String message) {
		try {
			writer.write(Log.FORMAT.get(log, level, message));
			writer.flush();
		} catch (IOException e) {}
	}
}
