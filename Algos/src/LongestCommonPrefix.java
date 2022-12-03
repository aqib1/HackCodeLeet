package com.test.web3labs;

import java.util.Arrays;
import java.util.Objects;

public class LongestCommonPrefix {
    // "abc", "abf", "abcd"
    public static String longestCommonPrefix(String[] strs) {
        if(Objects.isNull(strs) || strs.length == 0) {
            return "";
        }

        if(strs.length == 1) {
            return strs[0];
        }

        Arrays.sort(strs);

        int size = strs.length;
        int minLengthWordSize = Math.min(strs[0].length(), strs[size - 1].length());

        int charIndex = 0;
        while(charIndex < minLengthWordSize && strs[0].charAt(charIndex) == strs[size - 1].charAt(charIndex))
            charIndex++;




        return strs[0].substring(0, charIndex);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"ananbwhj", "ananyuqtw", "ananwu"}));
    }
}
