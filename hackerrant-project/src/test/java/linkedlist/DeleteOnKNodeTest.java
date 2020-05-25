package linkedlist;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeleteOnKNodeTest {
	private DeleteOnKNode deleteOnKNode;

	@Before
	public void init() {
		deleteOnKNode = new DeleteOnKNode();
	}

	@Test
	public void testDeleteNode() {
		SinglyLinkedListNode li = new SinglyLinkedListNode(2);
		li.next = new SinglyLinkedListNode(3);
		li.next.next = new SinglyLinkedListNode(4);
		SinglyLinkedListNode result = deleteOnKNode.deleteNode(li, 1);
		Assert.assertEquals(" 2 4", result.toString());
	}

	@Test
	public void testDeleteNodeMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "deleteNode";
		Class<?> c = DeleteOnKNode.class;
		Method method = c.getDeclaredMethod(methodName, SinglyLinkedListNode.class, int.class);
		Assert.assertNotNull(method);
	}
}
