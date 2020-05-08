import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class FindIndicies {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {}));
	}

	
	public static int solution(int[] A) {
		if (Objects.isNull(A) || A.length == 0)
			return 0;
		HashMap<Integer, Integer> count = new HashMap<>();
		// Lets count each number
		for (int x = 0; x < A.length; x++) {
			if (count.containsKey(A[x])) {
				count.put(A[x], count.get(A[x]) + 1);
			} else {
				count.put(A[x], 1);
			}
		}
		// now count the pairs with count * (count-1) / 2
		int pairs = 0;
		Set<Integer> keys = count.keySet();
		for (Integer key : keys) {
			int countValue = count.get(key);
			pairs += (countValue * (countValue - 1)) / 2;
		}
		return pairs;
	}
}
