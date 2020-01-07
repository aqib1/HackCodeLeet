package LandOfLogics;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class FileNaming {

	static String[] fileNaming(String[] names) {
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		for (String s : names) {
			if (map.containsKey(s)) {
				int val = map.get(s);
				String key = s + "(" + val + ")";
				while (map.containsKey(key)) {
					++val;
					key = s + "(" + val + ")";
				}
				map.put(key,  1);
				map.put(s, val + 1);
			} else {
				map.put(s, 1);
			}
		}
		return map.entrySet().stream().map(x -> x.getKey()).toArray(String[]::new);
	}

//	"a(1)", 
//	 "a(6)", 
//	 "a", 
//	 "a(2)", 
//	 "a(3)", 
//	 "a(4)", 
//	 "a(5)", 
//	 "a(7)", 
//	 "a(8)", 
//	 "a(9)", 
//	 "a(10)", 
//	 "a(11)"
	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				fileNaming(new String[] { "a(1)", "a(6)", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a" })));
	}

}
