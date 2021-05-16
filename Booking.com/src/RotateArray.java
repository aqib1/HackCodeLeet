
public class RotateArray {
	static void leftRotate(int arr[], int n, int k) {

		for(int x = k; x < n + k ; x++)
			System.out.println(arr[x % n]);
	}
	
	public static void main(String[] args) {
		leftRotate(new int[] {1, 2, 3},  3, 2);
	}
}
