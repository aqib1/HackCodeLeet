package linkedlist;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListCycleDetectionTest {

	@Test
	public void hasCycleMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "hasCycle";
		Class<?> c = LinkedListCycleDetection.class;
		Method method = c.getDeclaredMethod(methodName, SinglyLinkedListNode.class);
		Assert.assertNotNull(method);
	}
}
