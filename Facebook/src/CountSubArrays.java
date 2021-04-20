import java.util.Arrays;
import java.util.Stack;

public class CountSubArrays {

	public static int[] countSubarraysOpt(int[] arr) {
		int[] result = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i])
				result[i] += result[stack.pop()];
			stack.push(i);
			result[i]++;
		}

		stack.clear();
		
		int [] rightCount = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				int last = stack.pop();
				rightCount[i] += rightCount[last];
				result[i] += rightCount[last];
			}
			stack.push(i);
			rightCount[i]++;
		}

		return result;
	}

	public static int[] countSubarrays(int[] arr) {
		int[] result = new int[arr.length];
		for (int x = 0; x < arr.length; x++) {
			result[x] = 1;
			result[x] += countSubarrays(x - 1, arr, arr[x], -1, -1);
			result[x] += countSubarrays(x + 1, arr, arr[x], arr.length, 1);
		}
		return result;
	}

	private static int countSubarrays(int index, int[] arr, int value, int limit, int incr) {
		int count = 0;
		while (index != limit) {
			if (arr[index] > value)
				break;
			count++;
			index += incr;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(countSubarraysOpt(new int[] { 3, 4, 1, 6, 2 })));
	}
}
