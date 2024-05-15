package fluff.logging.format;

import fluff.logging.ILogger;
import fluff.logging.LogLevel;

public interface ILogFormatPart {
	
	String get(ILogger log, LogLevel level, String message);
}
