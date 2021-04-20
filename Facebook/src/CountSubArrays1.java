import java.util.Arrays;
import java.util.Stack;

public class CountSubArrays1 {

	public static int[] countSubarraysOptministic(int[] arr) {
		int[] result = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i])
				result[i] += result[stack.pop()];
			stack.push(i);
			result[i]++;
		}

		stack.clear();
		
		int[] rightCount = new int[arr.length];
		for(int i = arr.length - 1; i >= 0; --i) {
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				int index = stack.pop();
				rightCount[i] += rightCount[index];
				result[i] += rightCount[index];
			}
			
			stack.push(i);
			rightCount[i]++;
		}
		
		return result;
	}

	// O(n)2
	public static int[] countSubarrays(int[] arr) {
		int[] result = new int[arr.length];
		result[0]++;
		for (int i = 1; i < arr.length; i++) {
			result[i]++;
			int j = i + 1;
			while (j < arr.length && arr[i] > arr[j]) {
				result[i]++;
				j++;
			}
			j = i - 1;
			while (j >= 0 && arr[j] < arr[i]) {
				result[i]++;
				j--;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(countSubarraysOptministic(new int[] { 3, 4, 1, 6, 2 })));
	}
}
