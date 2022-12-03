package com.test.web3labs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberByIndex = new HashMap<>();
        int [] res = new int[2];
        for(int x=0; x<nums.length; x++) {
            int diff = target - nums[x];
            if(!numberByIndex.isEmpty() && numberByIndex.containsKey(diff)) {
                res[0] = numberByIndex.get(diff);
                res[1]  = x;
            } else {
                numberByIndex.put(nums[x], x);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {3, 2, 4}, 6)));
    }
}
