package linkedlist;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergePointOfLinkedListTest {

	private MergePointOfLinkedList mergePointOfLinkedList;

	@Before
	public void init() {
		mergePointOfLinkedList = new MergePointOfLinkedList();
	}

	@Test
	public void findMergeNodeTest() {
		SinglyLinkedListNode t1 = new SinglyLinkedListNode(3);
		t1.next = new SinglyLinkedListNode(2);
		t1.next.next = new SinglyLinkedListNode(4);

		SinglyLinkedListNode t2 = new SinglyLinkedListNode(5);
		t2.next = t1.next;
		t2.next.next = new SinglyLinkedListNode(9);

		Assert.assertTrue(2 == mergePointOfLinkedList.findMergeNode(t1, t2));
	}

	@Test
	public void testFindMergeNodeMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "findMergeNode";
		Class<?> c = MergePointOfLinkedList.class;
		Method method = c.getDeclaredMethod(methodName, SinglyLinkedListNode.class, SinglyLinkedListNode.class);
		Assert.assertNotNull(method);
	}
}
