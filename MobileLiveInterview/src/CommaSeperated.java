import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CommaSeperated {
	public static final String COMMA_SEPRARTOR = ",";
	public static final String EMPTY_STRING = "";
	
	public static String getCommaSeperatedString(List<Integer> data) {
		if(Objects.isNull(data) || data.isEmpty()) {
			return EMPTY_STRING;
		}
		return data.stream()
		.map(value -> (value % 2 == 0) ? "e" + value : "o" + value)
		.collect(Collectors.joining(COMMA_SEPRARTOR));
	}
	
	public static void main(String[] args) {
		System.out.println(getCommaSeperatedString(Arrays.asList(1, 2, 3, 4)));
	}
}
