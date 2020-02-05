package lybrinthOfNestedLoops;

public class PageNumberingWithInk {

	static int pagesNumberingWithInk(int current, int numberOfDigits) {
		String curr = current + "";
		String result = curr;
		do {
			Integer val = current + 1;
			if ((curr + val + "").length() > numberOfDigits)
				break;
			result += "," + val;
			curr += val + "";
			current = val;
		} while (curr.length() < numberOfDigits);
		return Integer.parseInt(result.split(",")[result.split(",").length - 1]);
	}

	public static void main(String[] args) {
		System.out.println(pagesNumberingWithInk(21, 5));

	}

}
