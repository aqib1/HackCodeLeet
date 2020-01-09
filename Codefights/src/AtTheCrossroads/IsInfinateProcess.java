package AtTheCrossroads;

public class IsInfinateProcess {
	boolean isInfiniteProcess(int a, int b) {
		return b < a ? true : Math.abs(a - b) % 2 != 0;
	}

	public static void main(String[] args) {

	}

}
