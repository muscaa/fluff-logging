package fluff.logging.format.parts;

import fluff.logging.ILogger;
import fluff.logging.LogLevel;
import fluff.logging.format.ILogFormatPart;

public class LogFormatPartConstant implements ILogFormatPart {
	
	private final String value;
	
	public LogFormatPartConstant(String value) {
		this.value = value;
	}
	
	@Override
	public String get(ILogger log, LogLevel level, String message) {
		return value;
	}
}
