package datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class Graph {
	private int V;
	private List<Integer> adjancencyList[];

	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;
		adjancencyList = new ArrayList[V];
		IntStream.range(0, V).forEach(x -> {
			adjancencyList[x] = new ArrayList<>();
		});
	}

	// O(V+E)
	public void BFS(int v) {
		boolean visited[] = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = true;
		while(!queue.isEmpty()) {
			int q = queue.poll();
			System.out.print(q + " ");
			Iterator<Integer> it = adjancencyList[q].iterator();
			while(it.hasNext()) {
				int edge = it.next();
				if(!visited[edge]) {
					visited[edge] = true;
					queue.add(edge);
				}
			}
		}
	}
	
	public void DFS(int v) {
		boolean visited[] = new boolean[V];
		DFS(v, visited);
	}

	// O(V+E)
	
	private void DFS(int v, boolean[] visited) {
		System.out.print(v + " ");
		visited[v] = true;
		Iterator<Integer> it = adjancencyList[v].iterator();
		while (it.hasNext()) {
			int edge = it.next();
			if (!visited[edge])
				DFS(edge, visited);
		}
	}

	public void addEdge(int v, int e) {
		adjancencyList[v].add(e);
	}

	public int getVertices() {
		return V;
	}

	// Driver Code
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
