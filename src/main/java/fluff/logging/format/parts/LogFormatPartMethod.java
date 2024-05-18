package fluff.logging.format.parts;

import fluff.logging.ILogger;
import fluff.logging.LogConfig;
import fluff.logging.LogLevel;
import fluff.logging.format.ILogFormatPart;

/**
 * Represents a method log format part.
 */
public class LogFormatPartMethod implements ILogFormatPart {
    
    @Override
    public String get(ILogger log, LogLevel level, String message) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length > LogConfig.TRACE_BACK) {
            StackTraceElement currentElement = stackTrace[LogConfig.TRACE_BACK];
            return currentElement.getMethodName();
        }
        return "unknown";
    }
}
