import java.util.ArrayList;
import java.util.List;

public class Substrings {

	// abc
	/*
	 * 0,1 0,2 0,3 1,2 1,3 2,3
	 **/
	public static List<String> allSubStrings(String s) {
		List<String> sub = new ArrayList<>();
		for (int x = 0; x < s.length(); x++)
			for (int y = (x + 1); y <= s.length(); y++)
				sub.add(s.substring(x, y));
		return sub;
	}

	public static void main(String[] args) {
		System.out.println(allSubStrings("abc"));
	}

}
