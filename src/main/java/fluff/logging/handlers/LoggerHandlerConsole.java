package fluff.logging.handlers;

import java.io.PrintWriter;
import java.io.StringWriter;

import fluff.logging.ILogger;
import fluff.logging.ILoggerHandler;
import fluff.logging.Log;
import fluff.logging.LogLevel;
import fluff.logging.utils.StringUtils;

/**
 * A console logger handler that prints log messages to the standard output.
 */
public class LoggerHandlerConsole implements ILoggerHandler {
    
    @Override
    public void print(ILogger log, LogLevel level, Object obj) {
        System.out.println(Log.FORMAT.get(log, level, String.valueOf(obj)));
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
