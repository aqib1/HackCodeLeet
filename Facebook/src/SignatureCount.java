import java.util.Arrays;

public class SignatureCount {

	public static int[] findSignatureCounts(int[] arr) {
		int[] signature = new int[arr.length];
		
		for(int i=0; i < arr.length; i++) {
			int sign = 1;
			int index = arr[i] - 1;
			while(arr[index] != arr[i]) {
				++sign;
				index = arr[index] - 1;
			}
			signature[i] = sign;
		}
		return signature;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findSignatureCounts(new int[] {5,3,9,4,1,8,6,2,7})));
	}

}
