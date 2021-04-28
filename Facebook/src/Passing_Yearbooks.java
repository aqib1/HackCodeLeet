import java.util.Arrays;
import java.util.Objects;

public class Passing_Yearbooks {
	public static int[] findSignatureCounts(int[] arr) {
		if (Objects.isNull(arr))
			return null;
		int[] result = new int[arr.length];

		for (int x = 0; x < arr.length; x++) {
			int sign = 1;
			int i = x;
			while (x != arr[i] - 1) {
				i = arr[i] - 1;
				sign++;
			}

			result[x] = sign;
		}

		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findSignatureCounts(new int[] {1, 2})));
	}
}
