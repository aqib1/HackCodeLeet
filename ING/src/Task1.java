import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class Task1 {
	public static int solution(int[] A) {
		// write your code in Java SE 8
		if(Objects.isNull(A) || A.length == 0) {
			return 0;
		}
		AtomicReference<Integer> RESULT_VALUE = new AtomicReference<>(Integer.MAX_VALUE);
		IntStream.range(1, 7).forEach(number -> {
			AtomicReference<Integer> tmpCount = new AtomicReference<>(0);
			Arrays.stream(A).forEach(value -> {
				if (value != number) {
					if (value + number == 7) {
						tmpCount.getAndUpdate(v -> v + 2);
					} else {
						tmpCount.getAndUpdate(v -> v + 1);
					}
				}
			});

			if (tmpCount.get() < RESULT_VALUE.get()) {
				RESULT_VALUE.set(tmpCount.get());
			}
		});

		return RESULT_VALUE.get();
	}

	public static void main(String[] args) {
		int[] A1 = { 1, 6, 2, 3, 3, 2, 4, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 1, 1, 2, 3, 4, 5, 5, 4, 3, 2, 3,
				34, 5, 5, 5, 5, 6, 6, 6, 4, 3, 4, 3, 4, 2, 3, 1 };
//		int[] A = { 1, 6, 2, 3 };

		System.out.println(solution(A1));

	}
}
