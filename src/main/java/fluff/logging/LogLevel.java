package fluff.logging;

import java.util.ArrayList;
import java.util.List;

public record LogLevel(String name, List<ILoggerHandler> handlers) {
	
	public static final LogLevel DEBUG = new LogLevel("Debug", new ArrayList<>());
	public static final LogLevel INFO = new LogLevel("Info", new ArrayList<>());
	public static final LogLevel WARN = new LogLevel("Warn", new ArrayList<>());
	public static final LogLevel ERROR = new LogLevel("Error", new ArrayList<>());
	public static final LogLevel CRITICAL = new LogLevel("Critical", new ArrayList<>());
}
