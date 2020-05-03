package singlelinkedlist.com.linkedlist.impl;

import java.lang.reflect.Method;
import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	private LinkedList<Integer> linkedList;

	@Before
	public void init() {
		linkedList = new LinkedList<>();
	}

	@Test
	public void testPushMethod() {
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);

		Assert.assertTrue(linkedList.getSize() == 3);

		linkedList = null;
	}
	
	@Test
	public void testPeekMethod() {
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);

		Assert.assertTrue(linkedList.peek() == 3);
		Assert.assertTrue(linkedList.getSize() == 3);

		linkedList = null;
	}
	
	@Test(expected = EmptyStackException.class)
	public void testPeekMethodWithEmptyList() {
		Assert.assertTrue(linkedList.peek() == 3);
		linkedList = null;
	}
	
	@Test(expected = EmptyStackException.class)
	public void testPopMethodWithEmptyList() {
		Assert.assertTrue(linkedList.pop() == 3);
		linkedList = null;
	}
	
	@Test
	public void testDistinct() {
		linkedList.push(1);
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);
		linkedList.push(2);
		linkedList.distinct();
		Assert.assertTrue(linkedList.getSize() == 3);
		Assert.assertEquals(linkedList, getDistinctLinkedList());
	}
	
	private Object getDistinctLinkedList() {
		LinkedList<Integer> li = new LinkedList<>();
		li.push(1);
		li.push(3);
		li.push(2);
		return li;
	}

	@Test
	public void testPopMethod() {
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);

		Assert.assertTrue(linkedList.pop() == 3);
		Assert.assertTrue(linkedList.getSize() == 2);
		Assert.assertTrue(linkedList.pop() == 2);
		Assert.assertTrue(linkedList.getSize() == 1);

		linkedList = null;
	}
	
	@Test
	public void testdeleteMethod() {
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);
		Assert.assertTrue(2 == linkedList.delete(2));
		Assert.assertTrue(linkedList.getSize() == 2);
		Assert.assertEquals(linkedList.toString(), "[3, 1]");
		Assert.assertTrue(1 == linkedList.delete(1));
		Assert.assertTrue(linkedList.getSize() == 1);
		Assert.assertEquals(linkedList.toString(), "[3]");
		
		linkedList = null;
	}
	
	@Test(expected = EmptyStackException.class)
	public void testdeleteMethod1() {
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);
		Assert.assertTrue(2 == linkedList.delete(10));
		
		linkedList = null;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSubLinkedListForNegKth() {
		linkedList.subLinkedList(-1);
	}
	
	@Test
	public void testSubLinkedListForKth() {
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);
		linkedList.push(4);
		linkedList.push(5);
		LinkedList<Integer> result = linkedList.subLinkedList(2);
		System.out.println(result);
		Assert.assertTrue(result.getSize() == 3);
		Assert.assertEquals(result.toString(), "[3, 2, 1]");
	}

	@Test
	public void testLinkedListMethods() throws NoSuchMethodException, SecurityException {
		String methodName = "push";
		Class<?> c = LinkedList.class;
		Method method = c.getDeclaredMethod(methodName, Object.class);
		Assert.assertNotNull(method);
		methodName = "pop";
		method = c.getDeclaredMethod(methodName);
		Assert.assertNotNull(method);
		methodName = "peek";
		method = c.getDeclaredMethod(methodName);
		Assert.assertNotNull(method);
		methodName = "delete";
		method = c.getDeclaredMethod(methodName, Object.class);
		Assert.assertNotNull(method);
		methodName = "equals";
		method = c.getDeclaredMethod(methodName, Object.class);
		Assert.assertNotNull(method);
		methodName = "distinct";
		method = c.getDeclaredMethod(methodName);
		Assert.assertNotNull(method);
		methodName = "subLinkedList";
		method = c.getDeclaredMethod(methodName, int.class);
		Assert.assertNotNull(method);
	}
}
