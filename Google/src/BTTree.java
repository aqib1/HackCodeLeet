
public class BTTree<T> {
	private Node root;

	public static void main(String[] args) {

	}

	class Node {
		private T data;
		private Node left;
		private Node right;

		public void setData(T data) {
			this.data = data;
		}

		public T getData() {
			return data;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getLeft() {
			return left;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getRight() {
			return right;
		}
	}
}
