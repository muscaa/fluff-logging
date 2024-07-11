package fluff.logging.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import fluff.core.utils.StringUtils;
import fluff.logging.ILogger;
import fluff.logging.ILoggerHandler;
import fluff.logging.Log;
import fluff.logging.LogLevel;

/**
 * A logger handler that writes log messages to a specified {@link Writer}.
 */
public class LoggerHandlerWriter implements ILoggerHandler {
    
    private final Writer writer;
    
    /**
     * Constructs a new {@code LoggerHandlerWriter} with the specified writer.
     *
     * @param writer the writer to which log messages will be written
     */
    public LoggerHandlerWriter(Writer writer) {
        this.writer = writer;
    }
    
    @Override
    public void print(ILogger log, LogLevel level, Object obj) {
        try {
            writer.write(Log.FORMAT.get(log, level, String.valueOf(obj)));
            writer.flush();
        } catch (IOException e) {}
    }
    
    @Override
    public void print(ILogger log, LogLevel level, String message, Object... args) {
        print(log, level, StringUtils.format(message, args));
    }
    
    @Override
    public void print(ILogger log, LogLevel level, Throwable error) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        
        error.printStackTrace(pw);
        
        print(log, level, sw.toString().trim());
    }
}
