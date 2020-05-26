package linkedlist;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompareTwoLinkedListTest {
	private CompareTwoLinkedList compareTwoLinkedList;

	@Before
	public void setUp() {
		compareTwoLinkedList = new CompareTwoLinkedList();
	}

	@Test
	public void compareListsTest() {
		SinglyLinkedListNode li = new SinglyLinkedListNode(1);
		li.next = new SinglyLinkedListNode(2);
		li.next.next = new SinglyLinkedListNode(4);
		li.next.next.next = new SinglyLinkedListNode(5);

		SinglyLinkedListNode li1 = new SinglyLinkedListNode(1);
		li1.next = new SinglyLinkedListNode(2);
		li1.next.next = new SinglyLinkedListNode(4);
		li1.next.next.next = new SinglyLinkedListNode(5);

		Assert.assertTrue(compareTwoLinkedList.compareLists(li, li1));
	}

	@Test
	public void compareListsTest1() {
		SinglyLinkedListNode li = new SinglyLinkedListNode(1);
		li.next = new SinglyLinkedListNode(2);
		li.next.next = new SinglyLinkedListNode(4);
		li.next.next.next = new SinglyLinkedListNode(5);

		SinglyLinkedListNode li1 = new SinglyLinkedListNode(1);
		li1.next = new SinglyLinkedListNode(2);
		li1.next.next = new SinglyLinkedListNode(4);

		Assert.assertFalse(compareTwoLinkedList.compareLists(li, li1));
	}

	@Test
	public void compareListsMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "compareLists";
		Class<?> c = CompareTwoLinkedList.class;
		Method method = c.getDeclaredMethod(methodName, SinglyLinkedListNode.class, SinglyLinkedListNode.class);
		Assert.assertNotNull(method);
	}
}
