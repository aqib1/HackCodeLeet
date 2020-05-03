package singlelinkedlist.com.linkedlist.impl;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PartioningListTest {

	private PartioningList partioningList;

	@Before
	public void init() {
		partioningList = new PartioningList();
	}

	@Test
	public void partitionTest1() {
		ListNode ln = new ListNode(1);
		ln.next = new ListNode(5);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(2);
		ln.next.next.next.next = new ListNode(4);
		ln.next.next.next.next.next = new ListNode(2);
		ListNode result = partioningList.partition(ln, 3);

		Assert.assertEquals(result.val, 1);
		Assert.assertEquals(result.next.val, 2);
		Assert.assertEquals(result.next.next.val, 2);
		Assert.assertEquals(result.next.next.next.val, 3);
		Assert.assertEquals(result.next.next.next.next.val, 5);
		Assert.assertEquals(result.next.next.next.next.next.val, 4);
	}

	@Test
	public void partitionForNullList() {
		ListNode li = partioningList.partition(null, 1);
		Assert.assertNull(li);
	}

	@Test
	public void partitionMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "partition";
		Class<?> c = PartioningList.class;
		Method method = c.getDeclaredMethod(methodName, ListNode.class, int.class);
		Assert.assertNotNull(method);
	}
}
