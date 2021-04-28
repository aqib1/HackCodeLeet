import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumLenSubstring {
	// Sliding window approach
	public int minLengthSubstring(String s, String t) {
		Map<String, Long> charCountT = t.chars()
				.mapToObj(Character::toString)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		int matchCount = 0;
		int result = Integer.MAX_VALUE;
		Map<String, Long> windowCounts = new HashMap<>();
		int l = 0, r = 0;
		
		while(r < s.length()) {
			String currentChar = Character.toString(s.charAt(r));
			long value = windowCounts.getOrDefault(currentChar, 0l);
			windowCounts.put(currentChar, value + 1);
			
			if(charCountT.containsKey(currentChar) && windowCounts.get(currentChar) == charCountT.get(currentChar)) {
				matchCount++;
			}
			
			while(l <= r && matchCount == charCountT.size()) {
				result = Math.min(result, (r - l) + 1);
				String leftChar = Character.toString(s.charAt(l));
				
				if(charCountT.containsKey(leftChar) && windowCounts.get(leftChar) == charCountT.get(leftChar)) {
					matchCount--;
				}
				windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
				l++;
			}
			
			++r;
		}
		
		return result == Integer.MAX_VALUE ? -1 : result;
	}

	public static void main(String[] args) {
		MinimumLenSubstring v = new MinimumLenSubstring();
		System.out.println(v.minLengthSubstring("dcbdefebce", "fd"));
	}
}
