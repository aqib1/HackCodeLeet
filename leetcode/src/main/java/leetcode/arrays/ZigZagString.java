package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ZigZagString {
	
	public String convert(String s, int numRows) {
		if (Objects.isNull(s) || s.isEmpty() || numRows < 1)
			throw new IllegalArgumentException();
		if (numRows == 1)
			return s;
		int limitRows = Math.min(numRows, s.length());
		List<StringBuilder> rows = new ArrayList<>();
		for(int x=0; x<limitRows; x++)
			rows.add(new StringBuilder());
		int currRow = 0;
		boolean goingDown = false;
		for(char c: s.toCharArray()) {
			rows.get(currRow).append(c);
			if(currRow >= numRows - 1 || currRow <= 0) goingDown = !goingDown;
			currRow += goingDown ? 1:-1;
		}
		StringBuilder result = new StringBuilder();
		for(StringBuilder sb: rows) result.append(sb);
		return result.toString();
	}
}
