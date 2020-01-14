package challenges;

public class GiftSafety {

	static int giftSafety(String gift) {
		int count = 0;
		for (int x = 0; x <= gift.length() - 3; x++) {
			long v = gift.substring(x, x + 3).chars().distinct().count();
			if (v <= 2)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(giftSafety("doll"));
	}

}
