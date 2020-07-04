package algorithm;

import java.util.Objects;

public class NumbersOfBlackShapes {
	public static void main(String[] args) {
		char[][] shapes = { //
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, //
				{ 'O', 'O', 'O', 'O', 'O', 'X', 'O' }, //
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O' } };
		System.out.println(numberOfBlackShapes(shapes));
	}

	static int[] directions = { 0, 1, 0, -1, 0 };

	public static int numberOfBlackShapes(char[][] shapes) {
		if (Objects.isNull(shapes) || shapes.length == 0)
			return 0;

		int count = 0;
		for (int x = 0; x < shapes.length; x++) {
			for (int y = 0; y < shapes[x].length; y++) {
				if (shapes[x][y] == 'X') {
					blackShapeToWhite(shapes, x, y);
					count++;
				}
			}
		}
		return count;
	}

	private static void blackShapeToWhite(char[][] shapes, int x, int y) {
		shapes[x][y] = 'O';
		for (int d = 0; d < directions.length - 1; d++) {
			int xMove = x + directions[d];
			int yMove = y + directions[d + 1];
			if (xMove >= 0 && xMove < shapes.length && yMove >= 0 && yMove < shapes[x].length) {
				if (shapes[xMove][yMove] == 'X') {
					blackShapeToWhite(shapes, xMove, yMove);
				}
			}
		}

	}
}
