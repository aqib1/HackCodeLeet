package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph {

	public static void main(String[] args) {
		Vertex vertex[] = new Vertex[] { //
				new Vertex("a"), //
				new Vertex("c"), //
				new Vertex("b"), //
				new Vertex("d"), //
				new Vertex("e"), //
				new Vertex("f"), //
				new Vertex("g") //
		};
		List<List<Vertex>> edges = Arrays.asList(
				Arrays.asList(new Vertex("b", 50), new Vertex("c", 1), new Vertex("d", 11)),
				Arrays.asList(new Vertex("a", 1), new Vertex("e", 2)),
				Arrays.asList(new Vertex("a", 50), new Vertex("g", 16)),
				Arrays.asList(new Vertex("a", 11), new Vertex("f", 4), new Vertex("e", 3)),
				Arrays.asList(new Vertex("c", 2), new Vertex("d", 3)),
				Arrays.asList(new Vertex("d", 4), new Vertex("g", 17)),
				Arrays.asList(new Vertex("f", 17), new Vertex("b", 16)));

		Graph graph = new Graph();
		for (int x = 0; x < vertex.length; x++) {
			graph.addEdges(vertex[x], edges.get(x));
		}

		graph.printShortestPath(graph.shortestPathJikstraAlgorithm(vertex[0], vertex[5]));

	}

	private Map<Vertex, List<Vertex>> graph = new HashMap<>();
	private Set<String> nonVisited;

	public void addEdges(Vertex vertex, List<Vertex> edges) {
		graph.put(vertex, edges);
	}

	public void printShortestPath(Vertex vertex) {
		while (vertex != null) {
			System.out.print(vertex.name + " ");
			vertex = vertex.previous;
		}
	}

	public Vertex shortestPathJikstraAlgorithm(Vertex from, Vertex to) {
		PriorityQueue<Vertex> min_heap = new PriorityQueue<>((a, b) -> Integer.compare(a.distance, b.distance));
		nonVisited = graph.keySet().stream().map(grpah -> grpah.name).collect(Collectors.toSet());
		Vertex current = from;
		current.distance = 0;
		List<Vertex> adjVertics = graph.get(current);

		while (!nonVisited.isEmpty()) {
			for (Vertex adj : adjVertics) {
				if (nonVisited.contains(adj.name)) {
					adj.previous = current;
					adj.distance = Math.min(adj.distance, current.distance + adj.cost);
					min_heap.add(adj);
				}
			}
			nonVisited.remove(current.name);
			current = min_heap.poll();
			adjVertics = graph.get(current);
			if (current.equals(to))
				return current;
		}
		return null;

	}

	static class Vertex {
		Vertex previous;
		String name;
		int cost;
		int distance = Integer.MAX_VALUE;

		public Vertex(String name) {
			this.name = name;
		}

		public Vertex(String name, int cost) {
			this.name = name;
			this.cost = cost;
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

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return this.name.hashCode();
		}

	}
}
