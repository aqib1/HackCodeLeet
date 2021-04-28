import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class Contiguous_SubArray {
	public static int[] countSubarrays(int[] arr) {
		if (Objects.isNull(arr) || arr.length == 0)
			return null;
		int[] result = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		for (int x = 0; x < arr.length; x++) {
			while (!stack.isEmpty() && arr[x] > arr[stack.peek()]) {
				result[x] += result[stack.pop()];
			}
			stack.push(x);
			result[x]++;
		}

		stack.clear();
		
		int[] rightCount = new int[arr.length];
		for (int x = arr.length - 1; x >= 0; --x) {
			while (!stack.isEmpty() && arr[x] > arr[stack.peek()]) {
				int index = stack.pop();
				result[x] += rightCount[index];
				rightCount[x] += rightCount[index];
			}
			stack.push(x);
			rightCount[x]++;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(countSubarrays(new int[] { 3, 4, 1, 6, 2 })));
	}
}
