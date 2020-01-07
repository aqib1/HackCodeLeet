package LandOfLogics;

import java.util.Arrays;

public class SpiralNumber {

	/*
	 * {{1,2,3,4}, 
	 * 	{5,6,7,8}, 
	 * 	{9,10,11,12},
	 * 	{9,10,11,12}}
	 * 
	 */
	
	/*
	 * 1 2 3
	 * 0 0 4
	 * 7 6 5
	 * */
	static int[][] spiralNumbers(int n) {
		int[][] sprial = new int[n][n];
		int count = 1;
		int k = 0, l = 0, last_row = n - 1, last_col = n - 1;
		while(k <= last_col && l <= last_row) {
			for(int y=l; y<=last_col; y++) {
				sprial[k][y]=count++;
			}
			++k;
			for(int y=k; y<=last_row; y++) {
				sprial[y][last_col]=count++;
			}
			--last_col;
			if(l <= last_row) {
				for(int y=last_col; y>=l; y--) {
					sprial[last_row][y]=count++;
				}
			}
			--last_row;
			if(k <= last_col) {
				for(int y=last_row; y>=k;y--) {
					sprial[y][l]=count++;
				}
			}
			++l;
		}

		return sprial;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(spiralNumbers(4)));
	}

}
