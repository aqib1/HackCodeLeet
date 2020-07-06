package algos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllPossiblePermutations {

	// time complexity O(n) and space complexity O(n)
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		permutations(permutations, nums, 0, nums.length);
		return permutations;
	}

	private void permutations(List<List<Integer>> permutations, int[] nums, int l, int r) {
		if (l == r)
			permutations.add(IntStream.of(nums).boxed().collect(Collectors.toList()));
		else {
			for (int x = l; x < r; x++) {
				swap(nums, l, x);
				permutations(permutations, nums, l + 1, r);
				swap(nums, l, x);
			}
		}

	}

	private void swap(int[] nums, int l, int x) {
		int temp = nums[l];
		nums[l] = nums[x];
		nums[x] = temp;
	}
}
