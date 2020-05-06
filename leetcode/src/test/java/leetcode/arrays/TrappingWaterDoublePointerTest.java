package leetcode.arrays;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrappingWaterDoublePointerTest {

	private TrappingWaterDoublePointer trapping;

	@Before
	public void init() {
		trapping = new TrappingWaterDoublePointer();
	}

	@Test
	public void trapWithNull() {
		int size = trapping.trap(null);
		Assert.assertTrue(size == 0);
	}

	@Test
	public void trapWithEmpty() {
		int size = trapping.trap(new int[] {});
		Assert.assertTrue(size == 0);
	}

	@Test
	public void testTrapMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "trap";
		Class<?> c = TappingWaterProblem.class;
		Method method = c.getDeclaredMethod(methodName, int[].class);
		Assert.assertNotNull(method);
	}
}
