import java.util.EmptyStackException;
import java.util.Objects;

public class SinglyLinkedList<K> {
	private Node<K> root;

	// O(1)
	public void push(K k) {
		Node<K> curr = new Node<>(k);
		curr.setNext(root);
		root = curr;
	}

	public void delete(K k) {
		if (Objects.isNull(root))
			throw new EmptyStackException();
		if (root.getData() == k)
			root = root.getNext();

		Node<K> previous = root;
		Node<K> current = root.getNext();
		while (!Objects.isNull(current)) {
			if (current.getData() == k) {
				previous.setNext(current.getNext());
			}
			previous = current;
			current = current.getNext();
		}
	}
	
	// O(n)
	public String toString() {
		Node<K> point = root;
		String toString = "[";
		while (!Objects.isNull(point)) {
			toString += point.getData();
			if (!Objects.isNull(point.getNext()))
				toString += ", ";
			point = point.getNext();
		}
		toString += "]";
		return toString;

	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);

		System.out.println(linkedList);
//		linkedList.delete(1);
		System.out.println(linkedList);
	}
}
