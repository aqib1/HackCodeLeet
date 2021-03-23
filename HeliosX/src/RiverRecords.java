import java.util.Objects;

public class RiverRecords {
	
	public static void main(String[] args) {
		System.out.println(riverRecords(new int [] {5, 3, 2, 1, 9}));
	}
	
	//5, 3, 6, 7 , 4
	public static int riverRecords(int[] arr) {
		if (Objects.isNull(arr) || arr.length == 0)
			return -1;
		int lastMin = Integer.MAX_VALUE;
		int maxDiff = Integer.MIN_VALUE;
		for (int x = 0; x < arr.length; x++) {
			if (lastMin > arr[x]) {
				lastMin = arr[x];
			}
			
			if(maxDiff < arr[x] - lastMin) {
				maxDiff = arr[x] - lastMin;
			}
		}

		return maxDiff == 0 ? -1: maxDiff;
	}
}
