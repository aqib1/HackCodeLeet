package challenges;

import java.util.Arrays;

public class SpiralMatrixII {

		public static void main(String[] args) {
			System.out.println(Arrays.deepToString(generateMatrix(3)));
		}
	
	 	public static int[][] generateMatrix(int n) {
	     int[][] result = new int[n][n];
	     /*
	      * k = initial index of row
	      * l = initial index of column
	      * m = last index of row
	      * o = last index of column
	      * */
	     int count = 1;
	     int k=0, l=0, m = n, o = n;
	     
	     while(k < m && l < o) {
	    	 for(int x=l; x < o; x++) {
	    		 result[k][x] = count++;
	    	 }
	    	 k++;
	    	 for(int x=k; x < m; x++) {
	    		 result[x][o-1] = count++;
	    	 }
	    	 o--;
	    	 
	    	 if(k < m) {
	    		 for(int x=o-1; x>=l; x--) {
	    			 result[m-1][x] = count++;
	    		 }
	    		 m--;
	    	 }
	    	 
	    	 if(l < o) {
	    		 for(int x=m-1; x>=k; x--) {
	    			 result[x][l] = count++;
	    		 }
	    		 l++;
	    	 }
	     }
	     
	     return result;
	    }
}
