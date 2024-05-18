package fluff.logging.format.parts;

import fluff.logging.ILogger;
import fluff.logging.LogLevel;
import fluff.logging.format.ILogFormatPart;

/**
 * Represents a constant value log format part.
 */
public class LogFormatPartConstant implements ILogFormatPart {
    
    private final String value;
    
    /**
     * Constructs a LogFormatPartConstant with the specified constant value.
     *
     * @param value the constant value
     */
    public LogFormatPartConstant(String value) {
        this.value = value;
    }
    
    @Override
    public String get(ILogger log, LogLevel level, String message) {
        return value;
    }
}
