package algos;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		int p[] = { 1, 1, 5 };
		nextPermutation(p);
		System.out.println(Arrays.toString(p));
	}

	// Time complexity is O(n) + O(m) * O(l) as over all O(n)2
	// space complexity is O(1)
	public static void nextPermutation(int[] p) {
		// next permutation in lexicographical order
		// find highest p(x) where p(x) < p(x+1) if not found reverse all
		// find highest p(y) where p(x) < p(y)
		// swap p(x) with p(y)
		// reverse all p(x1), p(x2), p(x3) .... p(xn)

		int minX = -1;
		for (int x = p.length - 2; x >= 0; x--) {
			if (p[x] < p[x + 1]) {
				minX = x;
				break;
			}
		}
		if (minX == -1) {
			reverse(p, 0, p.length - 1);
		} else {
			for (int y = p.length - 1; y >= 0; y--) {
				if (p[minX] < p[y]) {
					int temp = p[y];
					p[y] = p[minX];
					p[minX] = temp;
					reverse(p, minX + 1, p.length - 1);

					break;
				}
			}
		}

	}

	private static void reverse(int[] p, int l, int r) {
		while (l < r) {
			int temp = p[r];
			p[r] = p[l];
			p[l] = temp;
			l++;
			r--;
		}

	}
}
