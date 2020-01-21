package looptunnel;

public class LeastFactorial {
	int leastFactorial(int n) {
		int mul = 1, c = 1;
		while (mul < n) mul *= c++;
		return mul;
	}

	public static void main(String[] args) {

	}

}
