package singlelinkedlist.com.linkedlist.impl;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListDeleteMiddleNodeTest {

	private LinkedListDeleteMiddleNode linkedListDeleteMiddleNode;
	private LinkedList<Integer> linkedList;
	
	@Before
	public void init() {
		linkedList = new LinkedList<>();
		linkedListDeleteMiddleNode = new LinkedListDeleteMiddleNode();
	}
	
	@Test
	public void testDeleteMiddle() {
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);
		linkedListDeleteMiddleNode.deleteMiddle(linkedList);
		Assert.assertEquals(linkedList, getLinkedListDeleteMiddle());
	}
	
	@Test
	public void testDeleteMiddle1() {
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);
		linkedList.push(4);
		linkedList.push(5);
		linkedListDeleteMiddleNode.deleteMiddle(linkedList);
		Assert.assertEquals(linkedList, getLinkedListDeleteMiddle1());
	}
	
	private Object getLinkedListDeleteMiddle1() {
		LinkedList<Integer> li = new LinkedList<>();
		li.push(1);
		li.push(2);
		li.push(4);
		li.push(5);
		return li;
	}

	private Object getLinkedListDeleteMiddle() {
		LinkedList<Integer> li = new LinkedList<>();
		li.push(1);
		li.push(3);
		return li;
	}

	@Test
	public void testDeleteMiddleNodeMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "deleteMiddle";
		Class<?> c = LinkedListDeleteMiddleNode.class;
		Method method = c.getDeclaredMethod(methodName, LinkedList.class);
		Assert.assertNotNull(method);
	}
}
