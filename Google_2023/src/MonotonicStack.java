import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class MonotonicStack {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var numberByNextGreater = new HashMap<>();
        var result = new int[nums1.length];
        // order in descending
        Stack<Integer> monotonicStack = new Stack<>();
        // traverse array from back-word
        for(int i = nums2.length - 1; i >= 0; i--) {
            while(!monotonicStack.isEmpty() && nums2[i] >= monotonicStack.peek()) {
                monotonicStack.pop();
            }
            if(monotonicStack.isEmpty()) {
                numberByNextGreater.put(nums2[i], -1);
            } else {
                numberByNextGreater.put(nums2[i], monotonicStack.peek());
            }
            monotonicStack.push(nums2[i]);
        }
        int i = 0;
        for(int val: nums1) {
            result[i++] = (int)numberByNextGreater.get(val);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(nextGreaterElement(new int[] {4,1,2}, new int[] {1,3,4,2}))
        );
    }
}
