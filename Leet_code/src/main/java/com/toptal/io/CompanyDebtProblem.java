package com.toptal.io;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class CompanyDebtProblem {
    private static final int ZERO = 0;

    // O(MLogN) where M is the number of elements of A and N is the negative numbers
    // are offering in min-heap
    public static int solution(int[] A) {
        if (Objects.isNull(A) || !notEmptyArray(A))
            return ZERO;
        Queue<Integer> minHeap = new PriorityQueue<>();
        int sum = ZERO;
        int iteration = ZERO;
        for (int amount : A) {
            if (amount < ZERO) minHeap.offer(amount);
            if (sum + amount < ZERO && !minHeap.isEmpty()) {
                sum += -1 * minHeap.poll();
                ++iteration;
            }
            if (sum + amount >= ZERO) sum += amount;
        }
        return iteration;
    }

    private static boolean notEmptyArray(int[] array) {
        return array.length != ZERO;
    }
}
