
public class StrStr {
	public static int strStr(final String A, final String B) {
		if (A.isEmpty() || B.isEmpty())
			return -1;

		int index = -1;
	
		for (int x = 0; x < A.length(); x++) {
			boolean matched = true;
			int current = x;
			for(int y = 0; y < B.length(); y++) {
				if(current >= A.length() || A.charAt(current) != B.charAt(y)) {
					matched = false;
					break;
				}
				current++;	
			}
			
			if(matched)
				return x;
		}

		return index;
	}
	
	public static void main(String[] args) {
		System.out.println(strStr("bbbbbbbbab", "baba"));
	}
}
