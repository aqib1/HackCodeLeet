package leetcode.arrays;

import java.lang.reflect.Method;
import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TwoSumTest {
	private TwoSum twoSum;

	@Before
	public void init() {
		twoSum = new TwoSum();
	}

	@Test(expected = EmptyStackException.class)
	public void testTwoSumWithNullArray() {
		twoSum.twoSum(null, 1);
	}

	@Test(expected = EmptyStackException.class)
	public void testTwoSumWithEmptyArray() {
		twoSum.twoSum(new int[] {}, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTwoSumIllegalArgumentException() {
		twoSum.twoSum(new int[] { 1 }, 3);
	}

	@Test
	public void testTwoSum() {
		int result[] = twoSum.twoSum(new int[] { 1, 2, 3, 4 }, 3);
		Assert.assertArrayEquals(new int[] { 0, 1 }, result);
	}

	@Test
	public void testTwoSumMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "twoSum";
		Class<?> c = TwoSum.class;
		Method method = c.getDeclaredMethod(methodName, int[].class, int.class);
		Assert.assertNotNull(method);
	}
}
