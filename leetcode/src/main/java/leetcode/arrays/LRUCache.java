package leetcode.arrays;

import java.util.HashMap;

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
public class LRUCache {

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(3);
		lru.put(1, 3);
		lru.put(2, 5);
		lru.put(3, 11);
		lru.get(1);
		lru.put(4, 12);
		System.out.println(lru.keyValue);
	}

	private Node head, tail;
	private HashMap<Integer, Node> keyValue = new HashMap<>();
	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.previous = head;

	}

	public int get(int key) {
		int value = -1;
		Node node = keyValue.get(key);
		if (node != null) {
			value = node.value;
			removeNode(node);
			addNode(node);
		}
		return value;
	}

	public void put(int key, int value) {
		Node node = keyValue.get(key);
		if (node != null) {
			node.setValue(value);
			removeNode(node);
			addNode(node);
		} else {
			if (keyValue.size() == capacity) {
				keyValue.remove(head.next.key);
				removeNode(head.next);
			}
			Node newNode = new Node(key, value);
			keyValue.put(key, newNode);
			addNode(newNode);
		}
	}

	private void addNode(Node newNode) {
		tail.previous.next = newNode;
		newNode.previous = tail.previous;
		tail.previous = newNode;
		newNode.next = tail;
	}

	private void removeNode(Node node) {
		Node previous = node.previous;
		previous.next = node.next;
		node.next.previous = previous;
	}

	class Node {
		Node previous, next;
		int key, value;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node() {
		}

		@Override
		public String toString() {

			return value + "";
		}
	}
}
