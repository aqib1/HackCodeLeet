import java.util.HashMap;

public class AirLineProblem {
	public static void main(String[] args) {
		System.out.println(solution(50, "40G"));
	}

	public static int solution(int N, String S) {
		// write your code in Java SE 8
		// defining seat labels Space O(10)
		if (N <= 0)
			return 0;
		char[] seatLabels = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K' };
		HashMap<Character, Integer> seatWithNumbers = new HashMap<Character, Integer>();
		// Time O(10) and Space O(10)
		for (int x = 0; x < seatLabels.length; x++)
			seatWithNumbers.put(seatLabels[x], x);
		// Defining boolean array to pre-populate which seats are reserved
		// Space O(N) where N is the number of rows
		boolean[][] reserved = new boolean[N][10];
		// Time O(n) where n depends upon the S which contains seats numbers
		if (S.length() != 0) {
			String[] data = S.split(" ");
			for (String d : data) {
				try {
					String number = "";
					char seatChar = 0;
					for (char c : d.toCharArray()) {
						if (Character.isDigit(c)) {
							number += Character.toString(c);
						} else
							seatChar = c;
					}
					reserved[Integer.parseInt(number) - 1][seatWithNumbers.get(seatChar)] = true;
				} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
					return 0;
				}
			}
		}

		int count = 0;
		// Loop through reserved boolean array and check available space
		// in the order of y = 1 where y, y+1, y+2 and y+3 for four family people and
		// making sure consecutive indexes are available. if not increment y with 2
		// indexes
		// Time Complexity O(N * 10) where N is the number of rows given
		for (int x = 0; x < reserved.length; x++) {
			for (int y = 1; y < reserved[x].length - 4; y += 2) {
				if (!reserved[x][y] && !reserved[x][y + 1] && !reserved[x][y + 2] && !reserved[x][y + 3]) {
					count++;
					reserved[x][y] = true;
					reserved[x][y + 1] = true;
					reserved[x][y + 2] = true;
					reserved[x][y + 3] = true;
				}
			}
		}
		return count;
	}
}
