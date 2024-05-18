package fluff.logging.named;

import fluff.logging.AbstractLogger;

/**
 * A logger implementation that associates a name with log messages.
 */
public class NamedLogger extends AbstractLogger {
    
    private final String name;
    
    /**
     * Constructs a new NamedLogger with the specified name.
     *
     * @param name the name of the logger
     */
    public NamedLogger(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }
}
