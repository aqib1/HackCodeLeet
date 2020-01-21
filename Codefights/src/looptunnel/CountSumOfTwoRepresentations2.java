package looptunnel;

public class CountSumOfTwoRepresentations2 {

	static int countSumOfTwoRepresentations2(int n, int l, int r) {
		int count = 0;
		for (int x = l; x <= r; x++) {
				if (n-x >= x && n-x <= r)
					count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countSumOfTwoRepresentations2(6,2,4));
	}

}
