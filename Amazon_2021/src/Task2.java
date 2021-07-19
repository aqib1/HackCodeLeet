import java.util.*;

public class Task2 {

	public static long carParkingRoof(List<Long> cars, int k) {
		Collections.sort(cars);
		long min = Long.MAX_VALUE;
		for (int i = 0; i < cars.size() - k + 1; i++) {
			min = Math.min(min, cars.get(i + k - 1) - cars.get(i));
		}
		return min + 1;
	}

	public static void main(String[] args) {
		System.out.println(carParkingRoof(Arrays.asList(2L, 10L, 8L, 17L), 3));
	}
	
	
}
