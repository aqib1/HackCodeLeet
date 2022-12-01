import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.IntStream;

public class MonotonicStack {


    // Leetcode : https://leetcode.com/problems/next-greater-element-ii/description/
    // Approach Monotonic stacks
    // Time complexity is O(N x M) where M is the number of elements,
    // stack will remove while maintaining order in worst case.
    // Space complexity O(N)
    public static int[] nextGreaterElements(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) return null;

        Stack<Integer> monotonicStack = new Stack<>();
        var result = new int[nums.length];
        int limit = nums.length;
        for (int last = (limit - 1) * 2; last >= 0; last--) {
            while (!monotonicStack.isEmpty()
                    && nums[last%limit] >= monotonicStack.peek()) {
                monotonicStack.pop();
            }

            if (monotonicStack.isEmpty()) {
                result[last%limit] = -1;
            } else {
                result[last%limit] = monotonicStack.peek();
            }
            monotonicStack.push(nums[last%limit]);
        }
        return result;
    }


    // Time complexity O(N x M) in worst case, where M are number
    // of elements need to removed when nums2[M] >= monotonicStack.peek()
    // Space O(N)
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var numberByNextGreater = new HashMap<>();
        var result = new int[nums1.length];
        // order in descending
        Stack<Integer> monotonicStack = new Stack<>();
        // traverse array from back-word
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!monotonicStack.isEmpty() && nums2[i] >= monotonicStack.peek()) {
                monotonicStack.pop();
            }
            if (monotonicStack.isEmpty()) {
                numberByNextGreater.put(nums2[i], -1);
            } else {
                numberByNextGreater.put(nums2[i], monotonicStack.peek());
            }
            monotonicStack.push(nums2[i]);
        }
        int i = 0;
        for (int val : nums1) {
            result[i++] = (int) numberByNextGreater.get(val);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(nextGreaterElements(new int[]{5,4,3,2,1}))
        );
    }
}
