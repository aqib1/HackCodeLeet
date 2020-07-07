package singlelinkedlist;

import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoubleLinkedListTest {
	private DoubleLinkedList<Integer> li;

	@Before
	public void init() {
		li = new DoubleLinkedList<>();
	}

	@Test
	public void testPush() {
		li.push(1);
		li.push(2);
		li.push(3);

		Assert.assertTrue(li.getSize() == 3);
		Assert.assertEquals(li.toString(), "[3, 2, 1]");

		li = null;
	}
	
	@Test
	public void testFifoString() {
		li.push(1);
		li.push(2);
		li.push(3);

		Assert.assertTrue(li.getSize() == 3);
		Assert.assertEquals(li.toFifoString(), "[1, 2, 3]");

		li = null;
	}

	@Test
	public void testPoll() {
		li.push(1);
		li.push(2);
		li.push(3);

		Assert.assertTrue(li.getSize() == 3);
		Assert.assertTrue(li.poll() == 1);
		li = null;
	}
	
	@Test(expected = EmptyStackException.class)
	public void testPollEmptyStack() {
		li.push(1);
		li.push(2);
		li.push(3);
		
		li.pop();
		li.pop();
		li.pop();
		
		Assert.assertTrue(li.poll() == 1);
		li = null;
	}
	
	@Test
	public void testPopFirst() {
		li.push(1);
		li.push(2);
		li.push(3);

		Assert.assertTrue(li.getSize() == 3);
		Assert.assertTrue(li.popFirst() == 1);
		Assert.assertTrue(li.getSize() == 2);
		Assert.assertTrue(li.popFirst() == 2);
		Assert.assertTrue(li.getSize() == 1);
		Assert.assertTrue(li.popFirst() == 3);
		Assert.assertTrue(li.getSize() == 0);
		li = null;
	}
	
	@Test(expected = EmptyStackException.class)
	public void testPopFirstEmptyStack() {
		Assert.assertTrue(li.popFirst() == 1);
		li = null;
	}
	
	@Test
	public void testPeek() {
		li.push(1);
		li.push(2);
		li.push(3);

		Assert.assertTrue(li.getSize() == 3);
		Assert.assertTrue(li.peek() == 3);

		li = null;
	}
	
	@Test
	public void testPop() {
		li.push(1);
		li.push(2);
		li.push(3);

		Assert.assertTrue(li.getSize() == 3);
		Assert.assertTrue(li.pop() == 3);
		Assert.assertTrue(li.getSize() == 2);
		Assert.assertTrue(li.pop() == 2);
		li = null;
	}
	
	@Test(expected = EmptyStackException.class)
	public void testPopFurNullStack() {
		Assert.assertTrue(li.pop() == 3);
		li = null;
	}
	
	@Test(expected = EmptyStackException.class)
	public void testPeekForNullStack() {
		Assert.assertTrue(li.peek() == 3);
		li = null;
	}
}
