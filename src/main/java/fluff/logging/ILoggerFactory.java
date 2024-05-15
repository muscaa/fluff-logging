package fluff.logging;

public interface ILoggerFactory {
	
	ILogger create(String name);
	
	ILogger create(Class<?> clazz);
}
