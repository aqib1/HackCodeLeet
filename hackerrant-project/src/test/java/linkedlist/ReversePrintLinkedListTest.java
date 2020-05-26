package linkedlist;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

public class ReversePrintLinkedListTest {

	@Test
	public void testReversePrint() throws NoSuchMethodException, SecurityException {
		String methodName = "reversePrint";
		Class<?> c = ReversePrintLinkedList.class;
		Method method = c.getDeclaredMethod(methodName, SinglyLinkedListNode.class);
		Assert.assertNotNull(method);
	}
}
