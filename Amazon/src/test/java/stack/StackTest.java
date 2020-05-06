package stack;

import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
	private Stack<Integer> li = null;

	@Before
	public void init() {
		li = new Stack<>();
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
