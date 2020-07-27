package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph {

	private Map<String, Vertex> edges = new HashMap<>();
	private Map<Vertex, List<Vertex>> adjVertices = new HashMap<>();
	private Set<String> visited = new HashSet<>();
	private Set<String> nonVisited;

	public void addVertexes(Vertex vertex) {
		edges.putIfAbsent(vertex.name, vertex);
		adjVertices.putIfAbsent(vertex, new ArrayList<>());
	}

	public void addEdges(Vertex vertex, Vertex edge) {
		adjVertices.get(vertex).add(edges.get(edge.name));
	}

	public Vertex shortestPathJikstraAlgorithm(String from, String to) {
		PriorityQueue<Vertex> min_heap = new PriorityQueue<>((a, b) -> Integer.compare(a.distance, b.distance));
		nonVisited = edges.keySet();
		Vertex current = edges.get(from);
		current.distance = 0;
		List<Vertex> adjVertics = adjVertices.get(current);

		while (true) {
			for (Vertex adj : adjVertics) {
				if (nonVisited.contains(current.name)) {
					adj.previous = current;
					adj.distance = Math.min(adj.distance, current.distance + current.cost);
					min_heap.add(adj);
				}
			}
			nonVisited.remove(current.name);
			current = min_heap.poll();
			adjVertics = adjVertices.get(current);
			if (current.name.equals(to))
				return current;
		}

	}

	class Vertex {
		Vertex previous;
		String name;
		int cost;
		int distance = Integer.MAX_VALUE;

		public Vertex(String name) {
			this.name = name;
		}

		public Vertex(String name, int cost, int distance) {
			this.name = name;
			this.cost = cost;
			this.distance = distance;
		}

		@Override
		public boolean equals(Object obj) {
			return this.name.equals(((Vertex) obj).name);
		}

	}
}
