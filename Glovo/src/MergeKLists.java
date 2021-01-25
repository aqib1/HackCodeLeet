import java.util.PriorityQueue;
import java.util.Queue;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		next = null;
	}

	@Override
	public String toString() {
		Node curr = this;
		String toString = "[";
		while (curr != null) {
			toString += curr.data + " ";
			curr = curr.next;
		}
		toString += "]";
		return toString;
	}
}

public class MergeKLists {

	// 2->4>6>8
	// 1>3>5>9
	//
	// O(k * log(N)) -> where k is number of parent nodes and N is the number of all nodes
	public static Node mergeKLists(Node[] nodes, int k) {
		Node head = null, last = null;
		// O(logN)
		Queue<Node> queue = new PriorityQueue<Node>((p, q) -> Integer.compare(p.data, q.data));
		for (int x = 0; x < k; x++) {
			queue.add(nodes[x]);
		}
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			if (curr.next != null)
				queue.add(curr.next);
			if (head == null) {
				head = last = curr;
			} else {
				last.next = curr;
				last = last.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		int k = 3;
		Node[] nodes = new Node[k];
		Node n1 = new Node(2);
		n1.next = new Node(5);
		n1.next.next = new Node(6);
		n1.next.next.next = new Node(10);
		nodes[0] = n1;

		n1 = new Node(7);
		n1.next = new Node(8);
		n1.next.next = new Node(9);
		n1.next.next.next = new Node(12);
		nodes[1] = n1;

		n1 = new Node(1);
		n1.next = new Node(3);
		n1.next.next = new Node(11);
		nodes[2] = n1;
		System.out.println(mergeKLists(nodes, k));
	}
}
