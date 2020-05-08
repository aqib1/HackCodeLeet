import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

public class SmallestPositiveInteger {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { -1, -3 }));
	}

	public static int solution(int[] A) {
		if (Objects.isNull(A) || A.length == 0)
			return 0;
		Set<Integer> s = new HashSet<>();

		IntStream.of(A).forEach(x -> {
			if (x > 0)
				s.add(x);
		});

		return IntStream.range(1, A.length + 2).filter(x -> !s.contains(x)).findFirst().getAsInt();

	}
}
