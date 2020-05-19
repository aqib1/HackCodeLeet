import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Task {
	public Map<String, String> decode(String s) {
		if (Objects.isNull(s))
			return null;
		if (s.isEmpty())
			return new HashMap<>();
		Map<String, String> map = new HashMap<>();
		// check multiple key value pairs
		if (s.contains("&")) {
			String[] keyValuePairs = s.split("&");
			Arrays.stream(keyValuePairs).forEach(keyValue -> {
				String pairs[] = keyValue(keyValue);
				map.put(pairs[0], pairs[1]);
			});
		} else {
			String pairs[] = keyValue(s);
			map.put(pairs[0], pairs[1]);
		}
		return map;
	}

	public String[] keyValue(String map) {
		if (!map.contains("="))
			throw new IllegalArgumentException("Invalid format");
		String[] keyValue = map.split("=");
		if (keyValue.length == 0)
			return new String[] { "", "" };
		return keyValue.length == 1 ? new String[] { keyValue[0], "" } : keyValue;
	}
}
