package fluff.logging;

import fluff.logging.format.LogFormat;

public class Log {
	
	public static final LogFormat FORMAT = LogFormat.compile();
	
	public static ILogger create(String name) {
		return LogConfig.FACTORY.create(name);
	}
	
	public static ILogger create(Class<?> clazz) {
		return LogConfig.FACTORY.create(clazz);
	}
}
