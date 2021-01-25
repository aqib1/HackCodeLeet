
public class Task1 {

	public int solution(String A, String B) {
		int count = 0;
			for(int x=0; x<A.length(); x++) {
				if(convert(A.charAt(x)) > convert(B.charAt(x))) {
					count++;
				}
			}
		return count;
	}

	public int convert(char c) {
		switch (c) {
		case 'A': {
			return 14;
		}
		case 'K': {
			return 13;
		}
		case 'Q': {
			return 12;
		}
		case 'J': {
			return 11;
		}
		case 'T': {
			return 10;
		}
		default:
			return Integer.parseInt(Character.toString(c));
		}
	}
}
