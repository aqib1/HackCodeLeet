/*
 *Treasure Island II
You have a map that marks the locations of treasure islands. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in.
There are other explorers trying to find the treasure. So you must figure out a shortest route to one of the treasure island.
Assume the map area is a two dimensional grid, represented by a matrix of characters.
You must start from one of the starting point(marked as 'S') of the map and can move one block up, down, left or right at a time.
The treasure island is marked as ‘X’ in a block of the matrix.
Any block with dangerous rocks or reefs will be marked as ‘D’. You must not enter dangerous blocks. You cannot leave the map area.
Other areas ‘O’ are safe to sail in.
Output the minimum number of steps to get to any of the treasure.
e.g.
Input
[
[‘S’, ‘O’, ‘O’, 'S', ‘S’],
[‘D’, ‘O’, ‘D’, ‘O’, ‘D’],
[‘O’, ‘O’, ‘O’, ‘O’, ‘X’],
[‘X’, ‘D’, ‘D’, ‘O’, ‘O’],
[‘X', ‘D’, ‘D’, ‘D’, ‘O’],
]

Output
3
Explanation
You can start from (0,0), (0, 3) or (0, 4). The treasure locations are (2, 4) (3, 0) and (4, 0). Here the shortest route is (0, 3), (1, 3), (2, 3), (2, 4).
 * 
 * */
public class TreasureIsland1 {
	private static int distance[] = { 0, 1, 0, -1, 0 };
	private static int MIN_VAL = Integer.MAX_VALUE;

	public static int treasureIsland(char[][] island) {
		for (int x = 0; x < island.length; x++)
			for (int y = 0; y < island[x].length; y++)
				if (island[x][y] == 'S')
					travelIsland(island, x, y, 0);
		return MIN_VAL == Integer.MAX_VALUE ? -1 : MIN_VAL;
	}

	// DFS O(E * V) = O(R * C)
	private static void travelIsland(char[][] island, int x, int y, int count) {
		if (island[x][y] == 'X') {
			MIN_VAL = Math.min(MIN_VAL, count);
			return;
		}
		island[x][y] = 'D';
		for (int d = 0; d < distance.length - 1; d++) {
			int newX = x + distance[d];
			int newY = y + distance[d + 1];
			if (valideMove(island, newX, newY)) {
				travelIsland(island, newX, newY, count + 1);
			}
		}
		island[x][y] = 'O';
	}

	private static boolean valideMove(char[][] island, int newX, int newY) {
		if (newX < 0 || newX >= island.length || newY < 0 || newY >= island[newX].length || island[newX][newY] == 'D'
				|| island[newX][newY] == 'S')
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		System.out.println(treasureIsland(new char[][] { { 'S', 'O', 'O', 'S', 'S' }, { 'D', 'O', 'D', 'O', 'D' },
				{ 'O', 'O', 'O', 'O', 'X' }, { 'X', 'D', 'D', 'O', 'O' }, { 'X', 'D', 'D', 'D', 'O' } }));
	}
}
