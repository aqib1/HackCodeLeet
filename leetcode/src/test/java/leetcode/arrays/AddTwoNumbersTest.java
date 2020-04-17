package leetcode.arrays;

import java.lang.reflect.Method;
import java.math.BigDecimal;
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
	public void testAddTwoNumbers() {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
		
		Assert.assertEquals(result.val, 7);
		Assert.assertEquals(result.next.val, 0);
		Assert.assertEquals(result.next.next.val, 8);
	}
	
	@Test
	public void testReverseNumberFromListNode() {
		ListNode li = new ListNode(4);
		li.next = new ListNode(2);
		li.next.next = new ListNode(1);
		BigDecimal number = addTwoNumbers.getReverseNumberFromListNode(li);
		Assert.assertEquals(number, BigDecimal.valueOf(124));
	}
	
	@Test
	public void testRverseListNodeFromNumber() {
		ListNode li = addTwoNumbers.reverseListNodeFromNumber(BigDecimal.valueOf(321));
		Assert.assertEquals(li.val, 1);
		Assert.assertEquals(li.next.val, 2);
		Assert.assertEquals(li.next.next.val, 3);
	}
	
	@Test(expected = EmptyStackException.class)
	public void testReverseNumberFromListNodeForNullList() {
		addTwoNumbers.getReverseNumberFromListNode(null);
	}
	
	@Test
	public void testReverseListNodeFromNumberMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "reverseListNodeFromNumber";
		Class<?> c = AddTwoNumbers.class;
		Method method = c.getDeclaredMethod(methodName, BigDecimal.class);
		Assert.assertNotNull(method);
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
	
	@Test
	public void testAddTwoNumbers9() {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(9);
		l1.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next.next.next.next = new ListNode(9);
		
		
		ListNode l2 = new ListNode(9);
		
		ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
		
		Assert.assertEquals(result.val, 0);
		Assert.assertEquals(result.next.val, 0);
		Assert.assertEquals(result.next.next.val, 0);
		Assert.assertEquals(result.next.next.next.val, 0);
		Assert.assertEquals(result.next.next.next.next.val, 0);
		Assert.assertEquals(result.next.next.next.next.next.val, 0);
		Assert.assertEquals(result.next.next.next.next.next.next.val, 0);
		Assert.assertEquals(result.next.next.next.next.next.next.next.val, 0);
		Assert.assertEquals(result.next.next.next.next.next.next.next.next.val, 0);
		Assert.assertEquals(result.next.next.next.next.next.next.next.next.next.val, 0);
		Assert.assertEquals(result.next.next.next.next.next.next.next.next.next.next.val, 1);
	}
}
