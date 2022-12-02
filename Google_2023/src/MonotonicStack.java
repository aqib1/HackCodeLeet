import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class MonotonicStack {

    // 534976
    // Leetcode : https://leetcode.com/problems/next-greater-element-iii/description/
    public static int nextGreaterNumberIII(int number) {
        char []numbers = String.valueOf(number).toCharArray();
        // Step - 1: to find next Greater number of a given number n
        // Iterate from right and find first number n1 which is smaller
        // than to its next number n2
        int indexOfNum = -1;
        for(int i = numbers.length - 1; i > 0; i--) {
            if((int)numbers[i - 1] < (int)numbers[i]) {
                indexOfNum = i - 1;
                break;
            }
        }

        // Step - 2: if we found indexOfNum is 0 its mean that number is in descending order
        // e.g. 54321 in that case there will be no next greater number having same
        // numbers, so we will return -1
        if(indexOfNum == -1) return -1;

        // Step - 3: now we need to iterate from indexOfNum to right side
        // and need to find number greater than numbers[indexOfNum] but smaller
        // than all other numbers on right side
        int smallestFirstNumber = Integer.parseInt(String.valueOf(numbers[indexOfNum]));
        int smallestNextNumber = Integer.MAX_VALUE;
        int nextIndex = indexOfNum;
        for(int indexOfSmallest = indexOfNum + 1; indexOfSmallest < numbers.length; indexOfSmallest++) {
            int nextNumber = Integer.parseInt(String.valueOf(numbers[indexOfSmallest]));
            if(nextNumber > smallestFirstNumber && nextNumber < smallestNextNumber) {
                smallestNextNumber = nextNumber;
                nextIndex = indexOfSmallest;
            }
        }
        // Step - 4: replace both numbers
        char num1 = numbers[indexOfNum];
        numbers[indexOfNum] = numbers[nextIndex];
        numbers[nextIndex] = num1;

        // Step - 5: Sort Array after indexOfNum
        Arrays.sort(numbers, indexOfNum + 1, numbers.length);

        long val = Long.parseLong(new String(numbers));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }

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

//        Bag<Double> d = new Bag<Double>();
        System.out.println(
                nextGreaterNumberIII(12443322)
        );
    }
}
