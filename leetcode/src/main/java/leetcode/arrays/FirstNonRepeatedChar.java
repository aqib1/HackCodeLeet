package leetcode.arrays;

public class FirstNonRepeatedChar {

	public static int firstNonRepeated(String value) {
		// do we have all string literals in lower case?
		value = value.toLowerCase();
		int [] count = new int[26];
		value.chars().forEach(v -> {
			count[v - 'a']++;
		});
		
		for (int x = 0; x < value.length(); x++) {
			if(count[value.charAt(x) - 'a']  == 1)
				return x;
		}
		
		
		
//		Map<Character, Long> count = value.chars().mapToObj(c -> (char) c)
//				.collect(Collectors.groupingBy(x -> x, Collectors.counting()));
//
//		for (int x = 0; x < value.length(); x++) {
//			if (count.get(value.charAt(x)) == 1) {
//				return x;
//			}
//		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(firstNonRepeated("wwZqqA"));

	}
}
