import java.util.Objects;

public class FirstCodingInterview {
//	Welcome to Facebook!
//
//	This is just a simple shared plaintext pad, with no execution capabilities.
//
//	When you know what language you would like to use for your interview,
//	simply choose it from the dropdown in the top bar.
//
//	Enjoy your interview!

	// tacocats --> True # tacocats --> tacocat
	// racercar --> True # racercar --> racecar, racrcar
	// kbayak --> True # kbayak --> kayak
	// acbccba --> True # acbccba --> abccba
	// abccbca --> True # abccbca --> abccba
	// abcd --> False
	// btnnure --> False
	// null/empty --> True

	// tbcedcb -->

	public static void main(String[] args) {
		System.out.println(palindrome(
				"aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
	}

	static boolean palindrome(String str) {
		if (Objects.isNull(str) || str.isEmpty())
			return Boolean.TRUE;

		int i = 0;
		int j = str.length() - 1;
		int count = 0;

		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				if (str.charAt(i + 1) != str.charAt(j) && str.charAt(i) != str.charAt(j - 1)) {
					System.out.print(str.substring(i, i + 5) +" , ");
					System.out.println(str.substring(j -1 , j + 5));
					return Boolean.FALSE;
				}
				if (str.charAt(i + 1) == str.charAt(j)) {
					i++;
				} else if (str.charAt(i) == str.charAt(j - 1)) {
					j--;
				}
				count++;
			} else {
				i++;
				j--;
			}
		}

		return count > 1 ? Boolean.FALSE : Boolean.TRUE;
	}

	// input = [2, 3, 1, 2, 4, 3, 1] N = 7, M = ?
	// K = 7, sum should be greater or equal than K, return minimum size of subarray
	// (contiguous)
	// output: return 2 → the length of the subarray [4, 3]
	// O(N * M)

	int minSubArray(int[] arr, int k) {
		if (Objects.isNull(arr) || arr.length == 0) {
			return -1;
		}

		int i = 0, j = 0;
		int MIN_LEN = Integer.MAX_VALUE;
		int sum = 0;

		while (i <= j) {
			sum += arr[j++];
			if (sum >= k) {
				MIN_LEN = Math.min(MIN_LEN, (j - i) + 1);
				j = ++i;
				sum = 0;
			}
		}
		return MIN_LEN;
	}

}
