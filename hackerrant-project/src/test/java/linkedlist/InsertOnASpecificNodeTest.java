package linkedlist;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InsertOnASpecificNodeTest {
	private InsertOnASpecificNode insertOnASpecificNode;

	@Before
	public void init() {
		insertOnASpecificNode = new InsertOnASpecificNode();
	}

	@Test
	public void testInsertNodeAtPosition() {
		SinglyLinkedListNode li = new SinglyLinkedListNode(1);
		li.next = new SinglyLinkedListNode(2);
		li.next.next = new SinglyLinkedListNode(4);
		li.next.next.next = new SinglyLinkedListNode(5);
		SinglyLinkedListNode result = insertOnASpecificNode.insertNodeAtPosition(li, 3, 4);
		Assert.assertEquals(" 1 2 4 5 3", result.toString());
	}

	@Test
	public void insertNodeAtPositionMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "insertNodeAtPosition";
		Class<?> c = InsertOnASpecificNode.class;
		Method method = c.getDeclaredMethod(methodName, SinglyLinkedListNode.class, int.class, int.class);
		Assert.assertNotNull(method);
	}
}
