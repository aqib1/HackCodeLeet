package revision;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class Graph {

	// Vertexes
	private int V;

	// edges
	private List<Integer> adjancencyList[];

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.V = v;
		adjancencyList= new ArrayList[V];
		IntStream.range(0, V).forEach(x -> {
			adjancencyList[x] = new ArrayList<>();
		});
	}

	public void addEdge(int v, int edge) {
		adjancencyList[v].add(edge);
	}

	public void DFS(int i) {
		if(i >= adjancencyList.length) {
			throw new IllegalArgumentException();
		}
		boolean[] visited = new boolean[V];
		DFS(i, visited);
	}

	// O(V+E)
	public void BFS(int i) {
		boolean []visited = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();
		visited[i] = true;
		queue.add(i);
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			System.out.print(v + " ");
			Iterator<Integer> it = adjancencyList[v].iterator();
			while(it.hasNext()) {
				int e = it.next();
				if(!visited[e]) {
					visited[e] = true;
					queue.add(e);
				}
			}
		}
	}
	
	// O(V+E)
	private void DFS(int i, boolean[] visited) {
		visited[i] = true;
		System.out.print(i + " ");
		Iterator<Integer> it = adjancencyList[i].iterator();
		while(it.hasNext()) {
			int edge = it.next();
			if(!visited[edge]) {
				DFS(edge, visited);
			}
		}
		
	}

	public static void main(String args[]) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal : ");

		g.BFS(0);
	}
}
