package fluff.logging.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fluff.logging.ILogger;
import fluff.logging.LogConfig;
import fluff.logging.LogLevel;
import fluff.logging.format.parts.LogFormatPartClass;
import fluff.logging.format.parts.LogFormatPartConstant;
import fluff.logging.format.parts.LogFormatPartLevel;
import fluff.logging.format.parts.LogFormatPartMessage;
import fluff.logging.format.parts.LogFormatPartMethod;
import fluff.logging.format.parts.LogFormatPartName;
import fluff.logging.format.parts.LogFormatPartThread;
import fluff.logging.format.parts.LogFormatPartTime;

public class LogFormat {
	
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
	
	private final ILogFormatPart[] parts;
	
	public LogFormat(List<ILogFormatPart> parts) {
		this.parts = new ILogFormatPart[parts.size()];
		for (int i = 0; i < parts.size(); i++) {
			this.parts[i] = parts.get(i);
		}
	}
	
	public String get(ILogger log, LogLevel level, String message) {
		StringBuilder sb = new StringBuilder();
		for (ILogFormatPart part : parts) {
			sb.append(part.get(log, level, message));
		}
		return sb.toString();
	}
	
	public static LogFormat compile() {
		List<ILogFormatPart> parts = new ArrayList<>();
		
		if (LogConfig.LOG_FORMAT == null) throw new IllegalStateException("Log format cannot be null!");
		
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
