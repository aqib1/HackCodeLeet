package darkwilderness;

public class KnapSackLight {

	static int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
		return (maxW < weight1 && maxW < weight2) ? 0
				: (maxW >= (weight1 + weight2)) ? value1 + value2
						: (maxW >= weight1 && maxW >= weight2) ? Math.max(value1, value2)
								: (maxW >= weight1) ? value1 : value2;

	}

	public static void main(String[] args) {
		System.out.println(knapsackLight(3, 4, 5, 3, 3));
	}
}
