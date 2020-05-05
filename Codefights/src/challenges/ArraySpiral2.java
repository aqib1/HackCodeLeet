package challenges;

import java.util.ArrayList;
import java.util.List;

public class ArraySpiral2 {
	
	public static void main(String[] args) {
		System.out.println(spiralOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));
	}

	/**
	 * k = start index of row 
	 * l = start index of col 
	 * m = end index of row 
	 * n = end index of col
	 */
	public static List<Integer> spiralOrder(final int[][] A) {
		int k = 0, l = 0, m = A.length, n = A[0].length;
		List<Integer> li = new ArrayList<>();

		while (k < m && l < n) {
			for (int x = l; x < n; x++) {
				li.add(A[k][x]);
			}
			k++;
			for (int x = k; x < m; x++) {
				li.add(A[x][n - 1]);
			}
			--n;
			if(k < m) {
				for(int x=n-1; x>=l; x--) {
					li.add(A[m-1][x]);
				}
				--m;
			}
			
			if(l < n) {
				for(int x=m-1; x>=k; x--) {
					li.add(A[x][l]);
				}
				l++;
			}
		}
		return li;
	}
}
