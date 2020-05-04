package challenges;

public class FindDuplicates {

	// using floyd's hare and tortoise theorem
	public int findDuplicate(int[] nums) {

		int hare = nums[0], tortoise = nums[0];
		do {
			tortoise = nums[tortoise];
			hare = nums[nums[hare]];
		} while (hare != tortoise);

		tortoise = nums[0];

		while (tortoise != hare) {
			tortoise = nums[tortoise];
			hare = nums[hare];
		}

		return tortoise;
	}
}
