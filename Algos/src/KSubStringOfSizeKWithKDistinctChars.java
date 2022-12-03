package com.test.web3labs;

import java.util.*;

public class KSubStringOfSizeKWithKDistinctChars {

    public static List<String> kSubstring(String s, int k) {
        if(Objects.isNull(s) || s.isEmpty()) {
            return new ArrayList<>();
        }

        Set<String> result = new HashSet<>();
        Set<String> tempChars = new HashSet<>();
        String tmpResult =  "";
        int current = 0;
        int previous = 0;
        while(current < s.length()) {
            String ch = String.valueOf(s.charAt(current));
            if(!tempChars.contains(ch) && tempChars.size() < k) {
                current++;
                tempChars.add(ch);
                tmpResult = tmpResult.concat(ch);
            } else {
                if(tempChars.size() == k) {
                    result.add(tmpResult);
                }
                previous++;
                current = previous;
                tmpResult = "";
                tempChars.clear();
            }
        }
        if(!tmpResult.isEmpty()) result.add(tmpResult);
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        System.out.println(kSubstring("awaglknagawunagwkwagl", 4));
    }
}
