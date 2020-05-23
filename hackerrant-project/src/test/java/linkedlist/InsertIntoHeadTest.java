package linkedlist;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InsertIntoHeadTest {
	private InsertIntoHead insertIntoHead;

	@Before
	public void init() {
		insertIntoHead = new InsertIntoHead();
	}

	@Test
	public void testInsertIntoHead() {
		SinglyLinkedListNode li = new SinglyLinkedListNode(2);
		li.next = new SinglyLinkedListNode(3);
		li.next.next = new SinglyLinkedListNode(4);

		SinglyLinkedListNode result = insertIntoHead.insertNodeAtHead(li, 1);
		Assert.assertEquals(" 1 2 3 4", result.toString());

	}

	@Test
	public void insertNodeAtHeadMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "insertNodeAtHead";
		Class<?> c = InsertIntoHead.class;
		Method method = c.getDeclaredMethod(methodName, SinglyLinkedListNode.class, int.class);
		Assert.assertNotNull(method);
	}
}
