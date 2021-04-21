import java.util.HashSet;
import java.util.Set;

public class MatchingPairs {

	public static int matchingPairs(String s, String t) {
		Set<Character> sMissMatch = new HashSet<>();
		Set<Character> tMissMatch = new HashSet<>();
		int len = s.length();
		for (int x = 0; x < len; x++) {
			if(s.charAt(x) != t.charAt(x)) {
				sMissMatch.add(s.charAt(x));
				tMissMatch.add(t.charAt(x));
			}
		}
		
		if(sMissMatch.isEmpty()) return len - 2;
		
		int pairs = len - sMissMatch.size();
		int same = 0;
		for(char chr : sMissMatch) {
			if(tMissMatch.contains(chr))
				same++;
			if(same == 2)
				break;
		}
		
		
		return pairs + same;

	}
}
