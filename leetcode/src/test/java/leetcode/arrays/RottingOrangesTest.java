package leetcode.arrays;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class RottingOrangesTest {

	private RottingOranges rottingOranges;
	
	@Before
	public void init() {
		rottingOranges = new RottingOranges();
	}
	
	@Test
	public void orangesRottingTestNullOranges() {
		int result = rottingOranges.orangesRotting(null);
		Assert.assertTrue(result == 0);
	}
	
	@Test
	public void orangesRottingTestEmptyOranges() {
		int result = rottingOranges.orangesRotting(new int[][] {});
		Assert.assertTrue(result == 0);
	}
	
	@Test
	public void orrangesRottingTest() {
		int result = rottingOranges.orangesRotting(new int[][] {{2,1,1},{1,1,0},{0,1,1}});
		Assert.assertTrue(result == 4);
	}
	
	@Test
	public void orangesRottingMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "orangesRotting";
		Class<?> c = RottingOranges.class;
		Method method = c.getDeclaredMethod(methodName, int[][].class);
		Assert.assertNotNull(method);
	}
}
