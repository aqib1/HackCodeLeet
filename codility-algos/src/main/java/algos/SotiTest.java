package algos;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class SotiTest {
	public int solution(int[] A) {
		Set<Integer> data = new HashSet<>();
		IntStream.range(0, A.length).map(x -> A[x]).forEach(x -> {
			if (x > 0)
				data.add(x);
		});

		return IntStream.range(1, A.length + 2).filter(x -> !data.contains(x)).findFirst().orElse(1);

	}
}
