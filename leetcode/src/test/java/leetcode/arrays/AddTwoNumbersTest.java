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
	
	public void testListNodeToNumberInReverse() {
		
	}

	@Test
	public void testAddTwoNumbersMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "addTwoNumbers";
		Class<?> c = AddTwoNumbers.class;
		Method method = c.getDeclaredMethod(methodName, ListNode.class, ListNode.class);
		Assert.assertNotNull(method);
	}
}
