package fluff.logging.named;

import fluff.logging.AbstractLogger;

public class NamedLogger extends AbstractLogger {
	
	private final String name;
	
	public NamedLogger(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
}
