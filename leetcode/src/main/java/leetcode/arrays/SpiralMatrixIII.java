package leetcode.arrays;

public class SpiralMatrixIII {

	/**
	 * -1,0 0,-1 0,0 0,1 1,0
	 */
	public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		int[][] result = new int[R * C][2];
		int index = 0;
		result[index++] = new int[] { r0, c0 };
		int[] direction = new int[] { 0, 1, 0, -1, 0 };
		int dt = 0, level = 0;
		int roundFactor = direction.length - 1;
		while (index < R * C) {
			if (dt == 0 || dt == 2)
					level++;
			for(int x=0; x<level; x++) {
				r0 += direction[dt];
				c0 += direction[dt+1];
				if(r0 >=0 && r0 < R && c0 >=0 && c0 < C)
					result[index++] = new int[] { r0, c0 };
			}
				dt = ++dt % roundFactor;
		}
		return result;
	}
}
