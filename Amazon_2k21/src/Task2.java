import java.util.Arrays;

public class Task2 {
	public int solution(int[] A) {
        // write your code in Java SE 8
       if (A.length <= 1) {
			return -2;
		}
		Arrays.sort(A);
		long miniumDistance = Long.MAX_VALUE;
		for (int i = 1; i < A.length; i++) {
			miniumDistance = Math.min(miniumDistance, Math.abs(A[i] - A[i - 1]));
		}
		return miniumDistance > 100000000 ? -1 : (int)miniumDistance;
    }
}
