import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ReerangeArray {
	public static void arrange(List<Integer> a) {
		if (Objects.isNull(a) || a.isEmpty()) {
			return;
		}

		for (int x = 0; x < a.size(); x++) {
			a.set(x, a.get(x) + (a.get(a.get(x)) % a.size()) * a.size());
		}
		
		for(int x = 0; x < a.size(); x++) {
			a.set(x, a.get(x) / a.size());
		}
	}
	
	public static void main(String[] args) {
		List<Integer> li = Arrays.asList(1, 0, 3, 2);
		arrange(li);
		System.out.println(li);
	}
}
