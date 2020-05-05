package challenges;

public class SpiralMatrixIII {

	/**
	 * 
	 * 	     -1,0
	 * 	0,-1  0,0	0,1
	 * 		  1,0
	 *  [0, 1, 0, -1, 0]
	 * */
	// O(n)2 with space O(n)
	public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		int[][] result = new int[R * C][2];
		int index = 0;
		result[index++] = new int[] {r0, c0};
		int d = 0, len = 0;
		int direction[] = {0 , 1, 0, -1, 0};
		while(index < R*C) {
			if(d==0 || d == 2) {
				len++;
			}
			for(int x=0; x<len; x++) {
				r0 += direction[d];
				c0 += direction[d+1];
				if(r0 >=0 && r0 < R && c0 >=0 && c0 < C)
				result[index++] = new int[] {r0, c0};
			}
			
			d= ++d % 4;
		}
		return result;
	}
}
