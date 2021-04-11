import java.util.HashMap;
import java.util.Map;
public class Solution6 {
	
	    
	    public static int countPerms(int n) {
	    // Write your code here
	    if (n == 0) return 0;
	        if (n == 1) return 5;

	        Map<Character, Integer> freqMap = new HashMap<>();
	        for (char ch : "aeiou".toCharArray()) {
	            freqMap.put(ch, 1);
	        }
	        Map<Character, char[]> matchMap = new HashMap<>();
	        matchMap.put('a', new char[]{'e'});
	        matchMap.put('e', new char[]{'a','i'});
	        matchMap.put('i', new char[]{'a', 'e', 'o', 'u'});
	        matchMap.put('o', new char[]{'i', 'u'});
	        matchMap.put('u', new char[]{'a'});
	        
	        for (int i = 2; i <= n; i++) {
	            Map<Character, Integer> freqMapNew = new HashMap<>();
	            for (Character ch : "aeiou".toCharArray()) {
	                int count = freqMap.get(ch);
	                for (Character ch1 : matchMap.get(ch)) {
	                    freqMapNew.put(ch1, (freqMapNew.getOrDefault(ch1, 0) + count) % 1000000007);
	                }
	            }
	            freqMap = new HashMap<>(freqMapNew);
	        }
	        
	        int res = 0;
	        for (int freq : freqMap.values()) {
	            res = (res + freq) % 1000000007;
	        }
	        
	        return res;      

	    }


}
