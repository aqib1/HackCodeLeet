package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Amazon2k20_TagContainer_Map_Approach {
	public static class PairString {
		private String first;
		private String second;

		public PairString(String first, String second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public String toString() {
			return first + " ," + second;
		}
	}

	public static List<String> largestItemAssociation(List<PairString> pairs) {
		if (pairs == null || pairs.isEmpty())
			return null;
		PriorityQueue<TreeSet<String>> max_heap = new PriorityQueue<>((a, b) -> {
			int sizeCompare = Integer.compare(b.size(), a.size());
			return sizeCompare == 0 ? (a.first().compareTo(b.first())) : sizeCompare;
		});
		Set<String> non_visited = new HashSet<>();
		Map<String, TreeSet<String>> graph = new HashMap<>();
		prepareGraphAndNonVisitedStates(pairs, non_visited, graph);
		graph.keySet().stream().forEach(key -> {
			Set<String> add = new TreeSet<>(Arrays.asList(key)); // effective final
			graph.get(key).forEach(edge -> {
				DFS(non_visited, edge, graph, add);
			});
			graph.get(key).addAll(add);
			max_heap.add(graph.get(key));
		});
		return max_heap.poll().stream().collect(Collectors.toList());
	}

	private static void DFS(Set<String> non_visited, String edge, Map<String, TreeSet<String>> graph, Set<String> add) {
		if (!graph.containsKey(edge) || !non_visited.contains(edge))
			return;
		add.addAll(graph.get(edge));
		non_visited.remove(edge);
		for (String subEdge : graph.get(edge))
			DFS(non_visited, subEdge, graph, add);
	}

	private static void prepareGraphAndNonVisitedStates(List<PairString> pairs, Set<String> non_visited,
			Map<String, TreeSet<String>> graph) {
		for (PairString pair : pairs) {
			if (graph.containsKey(pair.first)) {
				graph.get(pair.first).add(pair.second);
				graph.get(pair.second).add(pair.first);
			} else {
				graph.put(pair.first, new TreeSet<>(Arrays.asList(pair.second)));
				graph.put(pair.second, new TreeSet<>(Arrays.asList(pair.first)));
			}
			non_visited.addAll(Arrays.asList(pair.first, pair.second));
		}
	}

	public static void main(String[] args) {
		List<PairString> pairs = Arrays.asList( //
				new PairString("item2", "item3"), // -> item1, item3, item2
				new PairString("item0", "item1"), //
				new PairString("item2", "item1") //
		);

		System.out.println(largestItemAssociation(pairs));
	}
}
