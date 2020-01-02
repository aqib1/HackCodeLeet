package RainbowOfClarity;

public class ChessKnight {

	static int chessKnight(String cell) {
		int moves = 0;
		int lowerLimit = 'a';
		int uperLimit = 'h';
		int diff = 2;
		for (int x = 1; x <= 2; x++) {
			if ((int) cell.charAt(0) - x >= lowerLimit) {
				if (Integer.parseInt(Character.toString(cell.charAt(1))) + diff <= 8)
					moves++;
				if (Integer.parseInt(Character.toString(cell.charAt(1))) - diff >= 1)
					moves++;
			}
			--diff;
		}
		diff = 2;
		for (int x = 1; x <= 2; x++) {
			if ((int) cell.charAt(0) + x <= uperLimit) {
				if (Integer.parseInt(Character.toString(cell.charAt(1))) + diff <= 8)
					moves++;
				if (Integer.parseInt(Character.toString(cell.charAt(1))) - diff >= 1)
					moves++;
			}
			--diff;
		}
		return moves;
	}

	public static void main(String[] args) {
		System.out.println(chessKnight("d5"));

	}

}
