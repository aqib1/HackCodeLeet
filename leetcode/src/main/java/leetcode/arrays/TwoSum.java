package leetcode.arrays;

import java.util.EmptyStackException;
import java.util.Objects;

public class TwoSum {

	public int[] twoSum(int[] array, int target) {
		if(Objects.isNull(array) || array.length == 0)
			throw new EmptyStackException();
		if(array.length == 1) 
			return array;
		int[] result = new int[2];
		for(int z=0; z<array.length-1; z++) {
			if(array[z] + array[z+1] == target) {
				result[0] = z;
				result[1] = z+1;
				break;
			}
		}
			
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
