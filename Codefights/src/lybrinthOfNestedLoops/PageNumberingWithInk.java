package lybrinthOfNestedLoops;

public class PageNumberingWithInk {

	static int pagesNumberingWithInk(int current, int numberOfDigits) {
		String currVal = String.valueOf(current);
		int count = currVal.length();
		while (true) {
			if (count + currVal.length() > numberOfDigits) {
				break;
			}
			current++;
			currVal = String.valueOf(current);
			count += currVal.length();
		}

		return current;
	}

	public static void main(String[] args) {
		System.out.println(pagesNumberingWithInk(1, 5));

	}

}
