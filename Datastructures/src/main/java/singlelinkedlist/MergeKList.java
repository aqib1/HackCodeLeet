package singlelinkedlist;

import java.util.PriorityQueue;

public class MergeKList {

	// Insert operation in min-heap is O(1)
	// Get operation (get min value) is logN
	// Search operation is O(n)

	public static Node mergeKSortedLists(Node[] arr, int k) {
		Node result = null, pointer = null;
		PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>((a, b) -> Integer.compare(a.data, b.data));
		for (int x = 0; x < arr.length; x++)
			if (arr[x] != null)
				priorityQueue.add(arr[x]);
		while (!priorityQueue.isEmpty()) {
			Node cur = priorityQueue.remove();
			if (cur.next != null)
				priorityQueue.add(cur.next);
			if (result == null && pointer == null) {
				result = cur;
				pointer = result;
			} else {
				pointer.next = cur;
				pointer = pointer.next;
			}
		}
		return result;
	}

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}
}
