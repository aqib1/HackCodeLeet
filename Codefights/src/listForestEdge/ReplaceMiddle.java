package listForestEdge;

import java.util.Arrays;

public class ReplaceMiddle {

	static int[] replaceMiddle(int[] arr) {
		if(arr.length%2==0) {
			int p[] = new int[arr.length-1];
			int y = 0;
			for(int x=0;x<p.length;x++) {
				if(y == (arr.length/2) -1) {
					p[x] =  arr[y++] + arr[y++];
					continue;
				}
				p[x] = arr[y++];
			}
			return p;
		} 
			
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(replaceMiddle(new int [] {7, 2, 2, 5, 10, 7})));

	}

}
