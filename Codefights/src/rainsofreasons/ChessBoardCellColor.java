package rainsofreasons;

import java.util.HashMap;
import java.util.Map;

public class ChessBoardCellColor {
	private static final Map<Character, Integer> chessBoard = new HashMap<Character, Integer>() {
		/**
		* 
		*/
		private static final long serialVersionUID = -6896464822218876925L;

		{
			put('A', 0);
			put('B', 1);
			put('C', 2);
			put('D', 3);
			put('E', 4);
			put('F', 5);
			put('G', 6);
			put('H', 7);

		}
	};

	static boolean chessBoardCellColor(String cell1, String cell2) {
		char cell1Label = cell1.charAt(0);
		int cell1Numb = Integer.parseInt(Character.toString(cell1.charAt(1)));
		char cell2Label = cell2.charAt(0);
		int cell2Numb = Integer.parseInt(Character.toString(cell2.charAt(1)));
		if ((chessBoard.get(cell1Label) % 2 == 0 && chessBoard.get(cell2Label) % 2 == 0)
				|| (chessBoard.get(cell1Label) % 2 != 0 && chessBoard.get(cell2Label) % 2 != 0))
			if ((cell1Numb % 2 == 0 && cell2Numb % 2 == 0) || (cell1Numb % 2 != 0 && cell2Numb % 2 != 0))
				return true;
			else
				return false;
		if ((cell1Numb % 2 == 0 && cell2Numb % 2 != 0) || (cell1Numb % 2 != 0 && cell2Numb % 2 == 0))
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(chessBoardCellColor("A1", "H3"));
	}
}
