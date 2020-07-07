package tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BineryTreeTest {
	private BinaryTree<Integer> bt;
	
	@Before
	public void init() {
		bt = new BinaryTree<>();
	}
	
	@Test
	public void testAdd() {
		bt.add(22, 8);
		bt.add(11, 6);
		bt.add(13, 10);
		bt.add(44, 9);
		
		Assert.assertTrue(bt.height() == 3);
	}
}
