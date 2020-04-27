package leetcode.arrays;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NoOfIslandTest {

	private NosOfIsland noOfIsland;

	@Before
	public void init() {
		noOfIsland = new NosOfIsland();
	}

	@Test
	public void numIslandsMethodTestWithEmptyIsland() {
		int result = noOfIsland.numIslands(new char[][] {});
		Assert.assertTrue(result == 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void numIslandsMethodTestWithNullIsland() {
		noOfIsland.numIslands(null);
	}

	@Test
	public void numIslandsTest1() {
		int result = noOfIsland.numIslands(new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' }, });
		Assert.assertTrue(result == 3);
	}
	
	@Test
	public void numIslandsTest2() {
		int result = noOfIsland.numIslands(new char[][] { {'1'}, {'1'}});
		Assert.assertTrue(result == 1);
	}

	@Test
	public void numIslandsMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "numIslands";
		Class<?> c = NosOfIsland.class;
		Method method = c.getDeclaredMethod(methodName, char[][].class);
		Assert.assertNotNull(method);
	}
}
