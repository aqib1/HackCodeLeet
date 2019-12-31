package EruptionOfLight;

public class FractionComparison {

	static char fractionComparison(int[] a, int[] b) {
		double result = (double)(a[0] * b[1] - a[1] * b[0]) / a[1] * b[1];
		return result == 0 ? '=' : result > 0 ? '>' : '<';
	}

	public static void main(String[] args) {
		System.out.println(fractionComparison(new int[] { 3, 5 }, new int[] { 2, 3 }));
	}
}
