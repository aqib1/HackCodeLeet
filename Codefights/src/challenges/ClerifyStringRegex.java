package challenges;

import java.util.regex.Pattern;

public class ClerifyStringRegex {
	 static String classifyStrings(String s) {
		String bad = "[aeiou]{3}|[^aeiou?]{5}";
        String mixed = "(?=.{0,2}\\?)[aeiou?]{3}|(\\?=.{0,4}?)[^aeiou]{5}";
        return Pattern.compile(bad).matcher(s).matches() ? "bad" : 
        	Pattern.compile(mixed).matcher(s).matches() ? "mixed" : "good";

	}

	 
	public static void main(String[] args) {
		System.out.println(classifyStrings("???"));

	}

}
