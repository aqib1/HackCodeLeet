package com.test.web3labs;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BuildArrayFromPermutation {

    public static int[] buildArray(int[] nums) {
        int []res = new int[nums.length];
        IntStream.range(0, nums.length).forEach(i ->
            res[i] = nums[nums[i]]);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(buildArray(new int [] {0,2,1,5,3,4})));
    }
}
