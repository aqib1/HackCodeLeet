package leetcode.arrays;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SetZeroTest {

	private SetZeros setZero;

	@Before
	public void init() {
		setZero = new SetZeros();
	}

	public void testSetZeros() {
		int[][] data = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		setZero.setZeroes(data);
		Assert.assertArrayEquals(data[0], new int[] { 1, 0, 1 });
		Assert.assertArrayEquals(data[1], new int[] { 0, 0, 0 });
	}

	@Test
	public void testSetZeroMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "setZeroes";
		Class<?> c = SetZeros.class;
		Method method = c.getDeclaredMethod(methodName, int[][].class);
		Assert.assertNotNull(method);
	}
}
