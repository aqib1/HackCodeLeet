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
		System.out.println(linkedList);
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
	}
}
