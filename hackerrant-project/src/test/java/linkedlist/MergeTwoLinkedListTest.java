package linkedlist;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeTwoLinkedListTest {
	private MergeTwoLinkedList mergeTwoLinkedList;

	@Before
	public void setUp() {
		mergeTwoLinkedList = new MergeTwoLinkedList();
	}

	@Test
	public void mergeLists() {
		SinglyLinkedListNode li = new SinglyLinkedListNode(1);
		li.next = new SinglyLinkedListNode(2);
		li.next.next = new SinglyLinkedListNode(4);
		li.next.next.next = new SinglyLinkedListNode(5);

		SinglyLinkedListNode li1 = new SinglyLinkedListNode(6);
		li1.next = new SinglyLinkedListNode(7);

		SinglyLinkedListNode expected = new SinglyLinkedListNode(1);
		expected.next = new SinglyLinkedListNode(2);
		expected.next.next = new SinglyLinkedListNode(4);
		expected.next.next.next = new SinglyLinkedListNode(5);
		expected.next.next.next.next = new SinglyLinkedListNode(6);
		expected.next.next.next.next.next = new SinglyLinkedListNode(7);

		Assert.assertEquals(expected, mergeTwoLinkedList.mergeLists(li, li1));

	}

	@Test
	public void mergeListsMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "mergeLists";
		Class<?> c = MergeTwoLinkedList.class;
		Method method = c.getDeclaredMethod(methodName, SinglyLinkedListNode.class, SinglyLinkedListNode.class);
		Assert.assertNotNull(method);
	}
}
