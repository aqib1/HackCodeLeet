package com.test.web3labs;

import java.util.Arrays;

public class ConcatenationArray {

    public static int[] getConcatenation(int[] nums) {
        int[] res = new int [nums.length * 2];
        for(int x=0; x < res.length; x++) {
            res[x] = nums[x%nums.length];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getConcatenation(new int [] {1, 2, 1})));
    }
}
