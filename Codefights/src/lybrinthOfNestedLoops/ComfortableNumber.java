package lybrinthOfNestedLoops;

public class ComfortableNumber {

	static int comfortableNumbers(int l, int r) {
		int count = 0;
		for (int x = l; x <= r; x++) {
			for (int y = x + 1; y <= r; y++) {
				int lx = count(x);
				int ly = count(y);
				if (y >= (x - lx) && y <= (x + lx) && x >= (y - ly) && x <= (y + ly))
					count++;
			}
		}

		return count;
	}

	private static int count(int x) {
		return String.valueOf(x).chars().map(t -> Character.getNumericValue(t)).sum();
	}

	public static void main(String[] args) {
		System.out.println(comfortableNumbers(1, 9));
	}

}
