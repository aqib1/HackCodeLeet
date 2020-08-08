package leetcodemocksLive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Mock1 {

	public static int[] gardenNoAdj(int N, int[][] paths) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int x = 0; x <= N; x++)
			graph.add(new ArrayList<>());
		for (int[] path : paths) {
			graph.get(path[0]).add(path[1]);
			graph.get(path[1]).add(path[0]);
		}

		int[] result = new int[N + 1];
		for (int x = 1; x <= N; x++) {
			int[] flowers = new int[5];
			for (int edges : graph.get(x)) {
				flowers[result[edges]] = 1;
			}

			for (int flower = flowers.length - 1; flower >= 1; flower--) {
				if (flowers[flower] != 1)
					result[x] = flower;
			}
		}

		return Arrays.copyOfRange(result, 1, result.length);
	}

	public static int numTilePossibilities(String tiles) {
		Set<String> sequences = new HashSet<>();
		dfs(sequences, "", tiles);
		return sequences.size();
	}

	private static void dfs(Set<String> sequences, String current, String tiles) {
		if (!current.isEmpty())
			sequences.add(current);
		for (int i = 0; i < tiles.length(); i++) {
			dfs(sequences, current + tiles.charAt(i), tiles.substring(0, i) + tiles.substring(i + 1));
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(gardenNoAdj(3, new int[][] { { 1, 2 }, { 2, 3 }, { 3, 1 } })));

	}
}
