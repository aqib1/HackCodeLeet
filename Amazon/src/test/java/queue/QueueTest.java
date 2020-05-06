package queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {

	private Queue<Integer> queue = null;
	
	@Before
	public void init() {
		queue = new Queue<>();
	}
	
	@Test
	public void addTest() {
		queue.add(2);
		queue.add(3);
		queue.add(4);
		
		Assert.assertEquals(queue.toString(), "[2, 3, 4]");
	}
	
	@Test
	public void removeTest() {
		queue.add(2);
		queue.add(3);
		queue.add(4);
		
		Assert.assertTrue(queue.remove() == 2);
		Assert.assertTrue(queue.remove() == 3);
		Assert.assertTrue(queue.remove() == 4);
	}
}
