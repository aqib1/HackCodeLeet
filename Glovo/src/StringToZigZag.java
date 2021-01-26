import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StringToZigZag {

	// O(N)
	public static String convert(String s, int numRows) {
		List<List<String>> data = new ArrayList<>();
		for (int x = 0; x < numRows; x++) {
			data.add(new ArrayList<>());
		}

		boolean down = false;
		int row = 0;
		for (int x = 0; x < s.length(); x++) {
			data.get(row).add(String.valueOf(s.charAt(x)));
			if (row == numRows - 1 || row == 0)
				down = !down;
			row += down ? 1 : -1;

		}
		List<String> result = data.stream().flatMap(Collection::stream).collect(Collectors.toList());
		return result.stream().collect(Collectors.joining());
	}

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
	}
}
