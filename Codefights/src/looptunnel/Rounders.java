package looptunnel;

public class Rounders {
	static int rounders(int n) {
		int mul = 1;
		while (n > 10) {
			mul *= 10;
			n = (n/10) + (n%10 >=5 ? 1 : 0);
		}
		return mul * n;
	}

	public static void main(String[] args) {
		System.out.println(rounders(11));
	}

}
