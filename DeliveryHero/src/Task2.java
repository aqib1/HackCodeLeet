public class Task2 {
	// [1,2,3,5,6,7,8,9] = 5
	public static int longestConsectiveRun(int[] arr) {
		int max_run = 0;
		int i = 0, j = 0;

		while (i < arr.length - 1 && j < arr.length - 1) {
			if (Math.abs(arr[j+1] - arr[j]) == 1) {
				j++;
			} else {
				max_run = Math.max(max_run, (j - i) + 1);
				i = ++j;
			}
		}

		return (max_run = Math.max(max_run, (j - i) + 1));
	}

	public static void main(String[] args) {
		System.out.println(longestConsectiveRun(new int[] { 4, 5, 6, -6, -4, -3, -2, -1, 0, 2, 3, 4 }));
	}
}
