package com.test.web3labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainClass {

    public int solution3(int[] A) {
        // write your code in Java SE 8
        List<Integer> a  = Arrays.stream(A).boxed().collect(Collectors.toList());
        Collections.sort(a, Collections.reverseOrder());
        Integer[] A1 = a.toArray(new Integer[a.size()]);
        int pollSum=0;
        for(int poll : A){
            pollSum +=poll;
        }

        double minPollDes = (double) pollSum/2;
        int filter = 0;
        while(pollSum>minPollDes) {
            for(double poll : A1) {
                if(poll!=0) {
                    filter++;
                    poll = poll/2;
                    pollSum-=poll;
                    if(pollSum<=minPollDes) return filter;
                }
            }
        }

        return filter;
    }

    public static String solution(String message, int K) {
        if(K <= 0) {
            return "";
        }
        String [] words = message.split(" ");
        String answer = "";
        int currentLen = 0;

        for(int x=0; x < words.length; x++) {
            if(currentLen + words[x].length() <= K && !words[x].isBlank() && !words[x].equals(" ")) {
                answer = answer.concat(words[x]).concat(" ");
                currentLen += words[x].length() + 1;
            } else {
                break;
            }
        }

        return answer.trim();
    }

    public static int solution2(int[] P, int[] S) {
        int range = P.length;
        int [] vacantSeats = new int [range];
        for(int x=0; x<range; x++) {
            vacantSeats[x] = Math.abs(S[x] - P[x]);
        }
        List<Integer> indexesOfFullyAccupiedSeats = new ArrayList<>();
        List<Integer> vacantIndexes = new ArrayList<>();

        for(int x=0; x< vacantSeats.length; x++) {
            if(vacantSeats[x] == 0)
            indexesOfFullyAccupiedSeats.add(x);
            else
                vacantIndexes.add(x);
        }

        if(indexesOfFullyAccupiedSeats.size() == range) {
             return 0;
        }
        int count = 0;
//        Arrays.sort(P);
        for(int x=0; x<indexesOfFullyAccupiedSeats.size(); x++) {
            int person = P[indexesOfFullyAccupiedSeats.get(x)];
            for(int y =0; y <vacantIndexes.size(); y++) {
                person -= vacantSeats[vacantIndexes.get(y)];
                vacantIndexes.remove(y);
                if(person <= 0) {
                    count++;
                    break;
                }
            }
        }
        return range - count;
    }

    public static void main(String[] args) {
        System.out.println(solution2(new int [] {4,4,2,4}, new int [] {5,5,2,5}));
//        System.out.println(solution("Codility We test coders", 14));
    }
}
