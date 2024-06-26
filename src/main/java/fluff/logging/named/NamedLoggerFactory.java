package fluff.logging.named;

import fluff.logging.ILogger;
import fluff.logging.ILoggerFactory;

/**
 * A factory for creating named loggers.
 */
public class NamedLoggerFactory implements ILoggerFactory {
    
    @Override
    public ILogger create(String name) {
        return new NamedLogger(name);
    }
    
    @Override
    public ILogger create(Class<?> clazz) {
        return create(clazz.getSimpleName());
    }
}
