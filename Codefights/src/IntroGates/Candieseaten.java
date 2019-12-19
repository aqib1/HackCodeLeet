package IntroGates;

public class Candieseaten {
	static int candies(int n, int m) {
		if (n > m)
			return 0;
		if (n == m)
			return m;
		int val = n;
		while(val < m) {
			if((val+n) > m )
				return val;
			val+=n;
		}
		return val;
	}

	public static void main(String[] args) {
		System.out.println(candies(1, 2));
	}
}
