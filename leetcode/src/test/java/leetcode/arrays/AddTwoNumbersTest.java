package leetcode.arrays;

import java.lang.reflect.Method;
import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class AddTwoNumbersTest {
	
	private AddTwoNumbers addTwoNumbers;
	
	@Before
	public void init() {
		addTwoNumbers = new AddTwoNumbers();
	}
	
	@Test(expected = EmptyStackException.class)
	public void testAddTwoNumbersMethodWithNullListNode() {
		addTwoNumbers.addTwoNumbers(null, null);
	}
	
	@Test
	public void testReverseNumberFromListNode() {
		ListNode li = new ListNode(4);
		li.next = new ListNode(2);
		li.next.next = new ListNode(1);
		int number = addTwoNumbers.getReverseNumberFromListNode(li);
		Assert.assertEquals(number, 124);
	}
	
	@Test
	public void testReverseNumberFromListNodeMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "getReverseNumberFromListNode";
		Class<?> c = AddTwoNumbers.class;
		Method method = c.getDeclaredMethod(methodName, ListNode.class);
		Assert.assertNotNull(method);
	}

	@Test
	public void testAddTwoNumbersMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "addTwoNumbers";
		Class<?> c = AddTwoNumbers.class;
		Method method = c.getDeclaredMethod(methodName, ListNode.class, ListNode.class);
		Assert.assertNotNull(method);
	}
}
