import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task2 {
	public int solution(int[] ranks) {
		// write your code in Java SE 8
		if (Objects.isNull(ranks) || ranks.length == 0) {
			return 0;
		}

		Map<Integer, Long> rankByCounts = Arrays.stream(ranks).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Set<Integer> uniqueRanks = Arrays.stream(ranks).boxed().collect(Collectors.toSet());

		AtomicReference<Long> rankCounts = new AtomicReference<>(0L);
		uniqueRanks.forEach(uniqueRank -> {
			if (rankByCounts.containsKey(uniqueRank + 1)) {
				rankCounts.getAndUpdate(value -> value + rankByCounts.get(uniqueRank));
			}
		});

		return rankCounts.get().intValue();
	}
}
