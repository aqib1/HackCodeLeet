package generalbasicalgos;

import java.util.Objects;

public class UniqueStringCheck {

	// Time complexity O(n) and space complexity O(1) as chars is fixed length
	public boolean isUniqueString(String string) {
		if (Objects.isNull(string) || string.isEmpty())
			throw new IllegalArgumentException();
		int[] chars = new int[256];
		for (char c : string.toCharArray()) {
			if (chars[c] >= 1)
				return false;
			else
				chars[c]++;
		}

		return true;
	}
}
