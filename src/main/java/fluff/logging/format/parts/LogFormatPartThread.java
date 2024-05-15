package fluff.logging.format.parts;

import fluff.logging.ILogger;
import fluff.logging.LogLevel;
import fluff.logging.format.ILogFormatPart;

public class LogFormatPartThread implements ILogFormatPart {
	
	@Override
	public String get(ILogger log, LogLevel level, String message) {
		return Thread.currentThread().getName();
	}
}
