package singlelinkedlist.com.linkedlist.impl;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import singlelinkedlist.com.linkedlist.impl.CycledLinkedList.ListNode;

public class CycledLinkedListTest {

	private CycledLinkedList cycledLinkedList;
	
	@Before
	public void init() {
		cycledLinkedList = new CycledLinkedList();
	}
	
	@Test
	public void detectCycle() {
		ListNode li = new CycledLinkedList.ListNode(5);
		li.next = new ListNode(3);
		li.next.next = new ListNode(4);
		li.next.next.next = li.next;
		ListNode result = cycledLinkedList.detectCycle(li);
		Assert.assertEquals(result, li.next);
		
	}
	
	@Test
	public void detectCycle1() {
		ListNode li = new CycledLinkedList.ListNode(1);
		li.next = new ListNode(2);
		li.next.next = li;
		ListNode result = cycledLinkedList.detectCycle(li);
		Assert.assertEquals(result, li);
	}
	
	@Test
	public void detectCycle2() {
		ListNode li = new CycledLinkedList.ListNode(1);
		li.next = new ListNode(2);
		ListNode result = cycledLinkedList.detectCycle(li);
		Assert.assertEquals(result, null);
	}
	
	public void detectCycleMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "detectCycle";
		Class<?> c = CycledLinkedList.class;
		Method method = c.getDeclaredMethod(methodName, LinkedList.class);
		Assert.assertNotNull(method);
	}
}
