package leetcode.arrays;

import java.util.Objects;

public class ZigZagString {

	public String convert(String s, int numRows) {
		if(Objects.isNull(s) || s.isEmpty() || numRows < 1)
			throw new IllegalArgumentException();
		if(numRows == 1)
			return s;
		return s;
	}
}
