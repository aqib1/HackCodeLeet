package algorithm;

public class MaxMinValPathI {

	/**
	 * Given a two 2D integer array, find the max score of a path from the upper
	 * left cell to bottom right cell. The score of a path is the minimum value in
	 * that path.
	 * 
	 * Notice: the path can only right and down.
	 * 
	 * For example:
	 * 
	 * Input:
	 * 
	 * [7,5,3] [2,0,9] [4,5,9]
	 * 
	 * Here are some paths from [0,0] to [2,2] and the minimum value on each path:
	 * 
	 * path: 7->5->3->9->9, minimum value on this path: 3
	 * 
	 * path: 7->2->4->5->9, minimum value on this path: 2
	 * 
	 * path: 7->2->0->9->9, minimum value on this path: 0
	 * 
	 * path: 7->2->0->5->9, minimum value on this path: 0
	 * 
	 * In the end the max score(the min value) of all the paths is 3.
	 * 
	 * Output: 2
	 * 
	 * using dynamic programming
	 * 
	 * {0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}
	 */

	public static void main(String[] args) {
		System.out.println(getMaxMinValPathI(new int[][] { //
				{ 7, 5, 3 }, //
				{ 2, 0, 9 }, //
				{ 4, 5, 9 }

		}));

	}

	// space complexity is O(n+m)
	// time complexity is O(N)2

	/*
	 * This algorithm include path from starting point
	 */
	public static int getMaxMinValPathI(int[][] arr) {
		if (arr == null || arr.length == 0)
			return 0;
		int bfs[][] = new int[arr.length][arr[0].length];

		bfs[0][0] = arr[0][0];
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr[x].length; y++) {
				// do not change 0,0 and 1,0 and 0,1 values
				if (x == 0 && y == 0)
					continue;
				if (x == 0)
					bfs[x][y] = Math.min(arr[x][y], bfs[x][y - 1]);
				else if (y == 0)
					bfs[x][y] = Math.min(arr[x][y], bfs[x - 1][y]);

				// if its the last index
				else if (x == arr.length - 1 && y == arr.length - 1)
					bfs[x][y] = Math.max(bfs[x - 1][y], bfs[x][y - 1]);
				else {
					bfs[x][y] = Math.min(arr[x][y], Math.max(bfs[x - 1][y], bfs[x][y - 1]));
				}

			}
		}

		return bfs[bfs.length - 1][bfs[0].length - 1];

	}
}
