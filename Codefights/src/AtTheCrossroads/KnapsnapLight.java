package AtTheCrossroads;

public class KnapsnapLight {

	static int knapsackLight(int v1, int w1, int v2, int w2, int m) {
		return (w1 > m && w2 > m) ? 0
				: (w1 + w2) <= m ? (v1 + v2) : (w1 <= m && w2 <= m) ? Math.max(v1, v2) : (w1 <= m && w2 >= m) ? v1 : v2;
	}

	public static void main(String[] args) {
		System.out.println(knapsackLight(15, 2, 20, 3, 2));
	}

}
