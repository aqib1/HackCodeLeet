package looptunnel;

public class IncreaseNumberRoundness {
	static boolean increaseNumberRoundness(int n) {
		String val = String.valueOf(n);
		boolean foundZero = false;
		for (char c : val.toCharArray()) {
			if ((char)c == '0') {
				 foundZero= true;
			} else {
				if(foundZero)
					return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(increaseNumberRoundness(1111));
	}

}
