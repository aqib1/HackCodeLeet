package listForestEdge;

public class FirstReversetry {
	static int[] firstReverseTry(int[] arr) {
		if(arr.length <= 1) 
			return arr;
		/*
		 * a = a+b b = a-b a = a-b
		 */
		arr[0] = arr[0] + arr[arr.length - 1];
		arr[arr.length - 1] = arr[0] - arr[arr.length - 1];
		arr[0] = arr[0] - arr[arr.length - 1];
		return arr;
	}

	public static void main(String[] args) {

	}

}
