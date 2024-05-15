package fluff.logging.utils;

public class StringUtils {
	
	public static String format(String text, Object... args) {
		if (text == null || args == null) return text;
		
		StringBuilder sb = new StringBuilder();
		int arg = 0;
		for (int i = 0; i < text.length(); i++) {
			char c0 = text.charAt(i);
			
			if (c0 == '$' && i + 2 < text.length()) {
				char c1 = text.charAt(i + 1);
				char c2 = text.charAt(i + 2);
				
				if (c1 == '{' && c2 == '}') {
					Object o = arg < args.length ? args[arg] : null;
					arg++;
					
					sb.append(o);
					
					i += 2; // skip {}
					continue;
				}
			}
			
			sb.append(c0);
		}
		return sb.toString();
	}
}
