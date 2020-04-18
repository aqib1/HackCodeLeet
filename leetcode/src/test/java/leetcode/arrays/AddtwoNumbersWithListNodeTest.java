package leetcode.arrays;

import java.lang.reflect.Method;
import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddtwoNumbersWithListNodeTest {

	private AddTwoNumbersWithListNode addTwoNumbersWithListNode;

	@Before
	public void init() {
		addTwoNumbersWithListNode = new AddTwoNumbersWithListNode();
	}

	@Test(expected = EmptyStackException.class)
	public void testAddTwoNumbersNullListNode() {
		addTwoNumbersWithListNode.addTwoNumbers(null, null);
	}

	@Test
	public void testAddTwoNumbers() {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode result = addTwoNumbersWithListNode.addTwoNumbers(l1, l2);

		Assert.assertEquals(result.val, 7);
		Assert.assertEquals(result.next.val, 0);
		Assert.assertEquals(result.next.next.val, 8);
	}

	@Test
	public void testAddTwoNumbers1() {
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(7);
		l2.next = new ListNode(3);
		ListNode result = addTwoNumbersWithListNode.addTwoNumbers(l1, l2);
		Assert.assertEquals(result.val, 7);
		Assert.assertEquals(result.next.val, 3);
	}

	@Test
	public void testAddTwoNumbersMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "addTwoNumbers";
		Class<?> c = AddTwoNumbersWithListNode.class;
		Method method = c.getDeclaredMethod(methodName, ListNode.class, ListNode.class);
		Assert.assertNotNull(method);
	}
}
