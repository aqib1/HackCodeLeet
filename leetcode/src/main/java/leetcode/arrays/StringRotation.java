package leetcode.arrays;

import java.util.Objects;

public class StringRotation {

	public boolean stringRotate(String v1, String v2) {
		if (Objects.isNull(v1) || Objects.isNull(v2) || v1.isEmpty() || v2.isEmpty() || v1.length() != v2.length())
			return false;

		return (v1 + v1).indexOf(v2) != -1;
	}
}
