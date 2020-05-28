package linkedlist;

import java.lang.reflect.Method;

import org.junit.Test;

import junit.framework.Assert;

public class PrintLinkedListTest {

	@Test
	public void printLinkedListTest() throws NoSuchMethodException, SecurityException {
		String methodName = "printLinkedList";
		Class<?> c = PrintLinkedList.class;
		Method method = c.getDeclaredMethod(methodName, SinglyLinkedListNode.class);
		Assert.assertNotNull(method);
	}
}
