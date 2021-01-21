package leetcode.arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class ZalandoAlgos {
	
	public static int solution1(String str) {
		int count = 0;
	    Map<Character, Integer> charToIndexMap = new HashMap<>();
	    for (Character ch: str.toCharArray()) {
	        if (charToIndexMap.containsKey(ch)) {
	            charToIndexMap.put(ch, charToIndexMap.get(ch)+1);
	        } else {
	            charToIndexMap.put(ch, 1);
	        }
	    }
		
	    Queue<Integer> max_heap = new PriorityQueue<>(charToIndexMap.size(), Collections.reverseOrder());
	    max_heap.addAll(charToIndexMap.values());
	    while(!max_heap.isEmpty()) {
	    	int head = max_heap.poll();
	    	if(max_heap.isEmpty())
	    		break;
	    	if(head == max_heap.peek() && max_heap.peek() != 0) {
	    		max_heap.add(head -1);
	    		count++;
	    	}
	    }
	    
		return count; 
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(solution1("ccaaffddecee"));
//		System.out.println(solution("aaa"));
//		System.out.println(solution("abbabbc")); // 4
//		System.out.println(getHeighestTwoDigitNumber(""));
//		System.out.println(getHeighestTwoDigitNumber("45"));
//		System.out.println(getHeighestTwoDigitNumber("45671"));
//		System.out.println(getHeighestTwoDigitNumber("1521103"));
//		System.out.println(getHeighestTwoDigitNumber("58692"));
//		System.out.println(getHeighestTwoDigitNumber("599695"));
		
//		System.out.println(solution2(new int [] {}));
//		System.out.println(solution2(null));
//		System.out.println(solution2(new int[] {5, 2, 1, 4}));
//		System.out.println(solution2(new int[] {5, 2, 3, 1, 7}));
//		System.out.println(solution2(new int[] {6, 7, 1, 3, 1, 2, 8, 9, 2}));
//		System.out.println(solution2(new int[] {6, 7, 1, 3, 2, 8, 9, 2}));
	}

	// null | [] -> 0
	// 5, 2, 1, 4 -> 0
	// 5, 2, 3, 1, 7 -> 3
	// 6, 7, 1, 3, 2, 1, 8 -> 2
	public static int solution2(int[] arr) {
		if (Objects.isNull(arr) || arr.length <= 4) {
			return 0;
		}
		int p = 1;
		int q = arr.length - 2;
		int MIN_VALUE = Integer.MAX_VALUE;
		
		while (p < q - 1) {
			MIN_VALUE = Math.min(MIN_VALUE, arr[p] + arr[q]);
			if(arr[p] > arr[q]) {
				p++;	
			} else {
				q--;	
			}
		}

		return MIN_VALUE;
	}

	// "" -> 0
	// "aabccd" -> 2

	public static int solution(String str) {
		if (Objects.isNull(str) || str.length() == 0) {
			return 0;
		}
		Set<Character> unique = new HashSet<>();
		for (int x = 0; x < str.length(); x++) {
			unique.add(str.charAt(x));
		}
		return str.length() - unique.size();
	}

	// problem statement: find the highest 2 digit number in string
	// "" -> -1
	// "45" -> 45
	// 45671 -> 71
	// 1521103 -> 52
	// O(n) + O(n2) -> O(2n*n) -> O(n)2
	public static int getHeighestTwoDigitNumber(String number) {
		if (Objects.isNull(number) || number.length() == 0)
			return -1;
		if (number.length() == 2)
			return Integer.parseInt(number);
		// 32 bits
		int MAX_VALUE = Integer.MIN_VALUE; // -2^31
		for (int x = 1; x < number.length(); x++) {
			MAX_VALUE = Math.max(MAX_VALUE, Integer.parseInt(number.substring(x - 1, x + 1)));
		}
		return MAX_VALUE;
	}



}
