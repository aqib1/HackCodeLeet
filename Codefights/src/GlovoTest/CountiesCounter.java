package GlovoTest;

public class CountiesCounter {
	public static int solution(int[][] A) {
		int counter = 0;
		boolean[][] visited = new boolean[A.length][A[0].length];
		for (int x = 0; x < A.length; x++) {
			for (int y = 0; y < A[x].length; y++) {
				if (!visited[x][y])
					counter++;
				visitDirections(A, visited, x, y);
			}
		}
		return counter;
	}

	private static void visitDirections(int[][] a, boolean[][] visited, int x, int y) {
		int xMove = x, yMove = y;
		visited[xMove][yMove] = true;
		for (int l = 0; l < 2; l++) {
			if (l % 2 == 0) {
				if (yMove + 1 < a[x].length && a[x][y] == a[xMove][yMove + 1]) {
					if (!visited[xMove][yMove + 1]) {
						visitDirections(a, visited, xMove, yMove + 1);
					}
				}
				if (xMove + 1 < a.length && a[x][y] == a[xMove + 1][yMove]) {
					if (!visited[xMove + 1][yMove]) {
						visitDirections(a, visited, xMove + 1, yMove);
					}
				}
			} else {
				if (yMove - 1 >= 0 && a[x][y] == a[xMove][yMove - 1]) {
					if (!visited[xMove][yMove - 1]) {
						visitDirections(a, visited, xMove, yMove - 1);
					}
				}
				if (xMove - 1 >= a.length && a[x][y] == a[xMove - 1][yMove]) {
					if (!visited[xMove - 1][yMove]) {
						visitDirections(a, visited, xMove - 1, yMove);
					}
				}
			}
		}

	}

	public static void main(String[] args) {

		System.out.println(solution(new int[][] { { 5, 4, 4 }, { 4, 3, 4 }, { 3, 2, 4 }, { 2, 2, 2 }, { 3, 3, 4 },
				{ 1, 4, 4 }, { 4, 1, 1 } }));

	}

}
