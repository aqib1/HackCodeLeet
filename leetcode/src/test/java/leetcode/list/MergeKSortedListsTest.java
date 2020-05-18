package leetcode.list;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeKSortedListsTest {
	public MergeKSortedLists mergeKSortedLists;

	@Before
	public void init() {
		mergeKSortedLists = new MergeKSortedLists();
	}

	@Test
	public void testMerge() {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		ListNode[] lists = new ListNode[] { l1, l2, l3 };
		ListNode result = mergeKSortedLists.mergeKLists(lists);
		Assert.assertEquals(result.val, 1);
		Assert.assertEquals(result.next.val, 1);
		Assert.assertEquals(result.next.next.val, 2);
	}

	@Test
	public void testMergeKLists() throws NoSuchMethodException, SecurityException {
		String methodName = "mergeKLists";
		Class<?> c = MergeKSortedLists.class;
		Method method = c.getDeclaredMethod(methodName, ListNode[].class);
		Assert.assertNotNull(method);
	}
}
