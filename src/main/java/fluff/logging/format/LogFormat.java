package fluff.logging.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fluff.logging.ILogger;
import fluff.logging.LogConfig;
import fluff.logging.LogLevel;
import fluff.logging.format.parts.*;

/**
 * Class for formatting log messages based on a template.
 */
public class LogFormat {
	
    /** Map containing all available log format parts. */
    public static final Map<String, ILogFormatPart> PARTS = new HashMap<>();
    
    static {
        PARTS.put("message", new LogFormatPartMessage());
        PARTS.put("name", new LogFormatPartName());
        PARTS.put("level", new LogFormatPartLevel());
        PARTS.put("time", new LogFormatPartTime());
        PARTS.put("thread", new LogFormatPartThread());
        PARTS.put("class", new LogFormatPartClass());
        PARTS.put("method", new LogFormatPartMethod());
    }
    
    /** Array to store the format parts. */
    private final ILogFormatPart[] parts;
    
    /**
     * Constructs a LogFormat object with the given format parts.
     * @param parts The format parts to use.
     */
    public LogFormat(List<ILogFormatPart> parts) {
        this.parts = parts.toArray(new ILogFormatPart[0]);
    }
    
    /**
     * Formats the log message.
     * @param log The logger.
     * @param level The log level.
     * @param message The log message.
     * @return The formatted log message.
     */
    public String get(ILogger log, LogLevel level, String message) {
        StringBuilder sb = new StringBuilder();
        for (ILogFormatPart part : parts) {
            sb.append(part.get(log, level, message));
        }
        return sb.toString();
    }
    
    /**
     * Compiles the log format based on the configured format template.
     * @return The compiled log format.
     * @throws IllegalStateException if the log format is null.
     */
    public static LogFormat compile() {
        List<ILogFormatPart> parts = new ArrayList<>();
        
        if (LogConfig.LOG_FORMAT == null) {
            throw new IllegalStateException("Log format cannot be null!");
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LogConfig.LOG_FORMAT.length(); i++) {
            char c0 = LogConfig.LOG_FORMAT.charAt(i);
            if (c0 == '$' && i + 2 < LogConfig.LOG_FORMAT.length()) {
                char c1 = LogConfig.LOG_FORMAT.charAt(i + 1);
                if (c1 == '{') {
                    StringBuilder name = new StringBuilder();
                    for (int j = i + 2; j < LogConfig.LOG_FORMAT.length(); j++) {
                        char cj = LogConfig.LOG_FORMAT.charAt(j);
                        if (cj == '}') {
                            ILogFormatPart part = PARTS.get(name.toString());
                            
                            if (!sb.isEmpty()) {
                                parts.add(new LogFormatPartConstant(sb.toString()));
                                sb.setLength(0);
                            }
                            
                            if (part != null) parts.add(part);
                            
                            i = j;
                            break;
                        }
                        
                        name.append(cj);
                    }
                    continue;
                }
            }
            
            sb.append(c0);
        }
        
        if (!sb.isEmpty()) {
            parts.add(new LogFormatPartConstant(sb.toString()));
        }
        
        return new LogFormat(parts);
    }
}
