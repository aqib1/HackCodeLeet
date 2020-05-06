package leetcode.arrays;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TappingWaterProblemTest {

	private TappingWaterProblem tappingWaterProblem;

	@Before
	public void init() {
		tappingWaterProblem = new TappingWaterProblem();
	}

	@Test
	public void testTrap() {
		int store = tappingWaterProblem.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
		Assert.assertTrue(store == 6);
	}

	@Test
	public void testTrapWithNullArray() {
		int store = tappingWaterProblem.trap(null);
		Assert.assertTrue(store == 0);
	}

	@Test
	public void testTrapWithNullEmpty() {
		int store = tappingWaterProblem.trap(new int[] {});
		Assert.assertTrue(store == 0);
	}

	@Test
	public void testTrapMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "trap";
		Class<?> c = TappingWaterProblem.class;
		Method method = c.getDeclaredMethod(methodName, int[].class);
		Assert.assertNotNull(method);
	}
}
