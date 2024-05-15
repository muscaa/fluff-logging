package fluff.logging;

public interface ILoggerHandler {
	
	void print(ILogger log, LogLevel level, String message);
}
