package leetcode.arrays;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RottingOranges1Test {
	
	private RottingOranges1 rottingOranges;

	@Before
	public void init() {
		rottingOranges = new RottingOranges1();
	}
	
	@Test
	public void orangesRottingForEmptyArray() {
		int result = rottingOranges.orangesRotting(new int[][] {});
		Assert.assertTrue(result == 0);
	}
	
	@Test
	public void orangesRottingForNullArray() {
		int result = rottingOranges.orangesRotting(null);
		Assert.assertTrue(result == 0);
	}

	@Test
	public void orangesRottingMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "orangesRotting";
		Class<?> c = RottingOranges1.class;
		Method method = c.getDeclaredMethod(methodName, int[][].class);
		Assert.assertNotNull(method);
	}
}
