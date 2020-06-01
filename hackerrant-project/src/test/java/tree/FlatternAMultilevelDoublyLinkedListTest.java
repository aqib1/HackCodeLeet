package tree;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlatternAMultilevelDoublyLinkedListTest {

	private FlatternAMultilevelDoublyLinkedList flattern;

	@Before
	public void init() {
		flattern = new FlatternAMultilevelDoublyLinkedList();
	}

	@Test
	public void testFlatten() {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.prev = n;
		n.next.next = new Node(3);
		n.next.next.prev = n.next.next;

		Node c1 = new Node(7);
		c1.next = new Node(8);
		c1.next.prev = c1;
		n.next.child = c1;

		Node c2 = new Node(11);
		c2.next = new Node(12);
		c1.next.child = c2;

		Assert.assertEquals("1 2 7 8 11 12 3 ", flattern.flatten(n).toString());
	}

	@Test
	public void testFlattenMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "flatten";
		Class<?> c = FlatternAMultilevelDoublyLinkedList.class;
		Method method = c.getDeclaredMethod(methodName, Node.class);
		Assert.assertNotNull(method);

	}
}
