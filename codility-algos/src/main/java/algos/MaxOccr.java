package algos;

public class MaxOccr {
	public static void main(String[] args) {
		System.out.println(solution(10000, new int[] { 2, 10000, 3, 10000, 2, 3, 2, 0, 0, 3, 3, 3, 0, 0 }));
	}

	static int solution(int M, int[] A) {
		int[] count = new int[M + 1];
		int maxOccurence = 1;
		int index = 0;
		for (int i = 0; i < A.length; i++) {
			if (count[A[i]] > 0) {
				if (count[A[i]] > maxOccurence) {
					maxOccurence = count[A[i]];
					index = i;
				}
			} else {
				count[A[i]] = 1;
			}
			count[A[i]]++;
		}
		return A[index];
	}
}
