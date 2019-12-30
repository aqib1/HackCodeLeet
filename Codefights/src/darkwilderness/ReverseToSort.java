package darkwilderness;

import java.util.Arrays;

public class ReverseToSort {

	static boolean reverseToSort(int[] inputArray) {
		int[] cpyArr = new int[inputArray.length];
		System.arraycopy(inputArray, 0, cpyArr, 0, cpyArr.length);
		Arrays.sort(cpyArr);
		int front;
		for (front = 0; front < inputArray.length; front++)
			if (cpyArr[front] != inputArray[front])
				break;
		int back;
		for (back = inputArray.length - 1; back >= 0; back--)
			if (cpyArr[back] != inputArray[back])
				break;
		for (int x = front + 1; x <= back; x++)
			if (inputArray[x - 1] < inputArray[x])
				return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(reverseToSort(new int[] { 2, 3, 2, 4}));
	}

}
