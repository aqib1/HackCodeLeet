package linkedlist;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListCycleDetectionTest {
	private LinkedListCycleDetection linkedListCycleDetection;

	@Before
	public void setUp() {
		linkedListCycleDetection = new LinkedListCycleDetection();
	}

	@Test
	public void testHasCycle() {
		SinglyLinkedListNode li = new SinglyLinkedListNode(1);
		li.next = new SinglyLinkedListNode(2);
		li.next.next = li.next;
		Assert.assertTrue(linkedListCycleDetection.hasCycle(li));
	}

	@Test
	public void testHasCycle1() {
		SinglyLinkedListNode li = new SinglyLinkedListNode(1);
		li.next = new SinglyLinkedListNode(2);
		li.next.next = new SinglyLinkedListNode(3);
		Assert.assertFalse(linkedListCycleDetection.hasCycle(li));
	}

	@Test
	public void hasCycleMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "hasCycle";
		Class<?> c = LinkedListCycleDetection.class;
		Method method = c.getDeclaredMethod(methodName, SinglyLinkedListNode.class);
		Assert.assertNotNull(method);
	}
}
