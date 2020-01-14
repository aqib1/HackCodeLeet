package CornersOf0sAnd1s;

import java.util.Arrays;

/**
 * 
 * */
public class ArrayPacking {

	static int arrayPacking(int[] a) {
		String newVal = "";
		for (int x = a.length - 1; x >= 0; x--) {
			String binaryVal = Integer.toBinaryString(a[x]);
			newVal += binaryVal.length() < 8 ? getZeroFilled(8 - binaryVal.length()) + binaryVal : binaryVal;
		}
		return Integer.parseInt(newVal, 2);
	}

	static String getZeroFilled(int n) {
		char[] data = new char[n];
		Arrays.fill(data, '0');
		return new String(data);
	}

	public static void main(String[] args) {
		System.out.println(arrayPacking(new int[] {24, 85, 0}));
	}

}
