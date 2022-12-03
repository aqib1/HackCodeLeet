package com.test.web3labs;

import java.util.Arrays;
import java.util.Objects;

public class MahamTask {





    public static int solution(int [] arr) {
        if(Objects.isNull(arr) || arr.length == 0)
            return 0;
        if(arr.length == 1)
            return 1;
        Arrays.sort(arr);

        int count = 0;
        int LCS = -1;

        // 1, 2, 3
        for(int x=0; x< arr.length; x++) {
            if(x < arr.length - 1 && arr[x] + 1 == arr[x + 1]) {
              count++;
            } else {
                LCS = Math.max(LCS, count + 1);
                count = 0;
            }
        }
        return LCS;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int [] {1, 3,4,5, 6, 7,8, 9, 10, 12, 13, 14}));
    }







    public static int LCS(int [] arr) {
        if(Objects.isNull(arr) || arr.length == 0)
            return 0;
        if(arr.length == 1)
            return 1;
        Arrays.sort(arr);
        int countConsective = 1;
        int LCS = Integer.MIN_VALUE;

       for (int i =1; i < arr.length; i++) {

           if(arr[i] != arr[i-1]) {
               if (arr[i] - arr[i - 1] == 1) {
                   countConsective++;
               } else {
                   LCS = Math.max(LCS, countConsective);
                   countConsective = 1;
               }
           }
       }

        return Math.max(LCS, countConsective);
    }


}
