package leetcode.arrays;

import java.lang.reflect.Method;
import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TwoSumEffientSolutionTest {
	private TwoSumEffientSolution twoSumEffientSolution;

	@Before
	public void init() {
		twoSumEffientSolution = new TwoSumEffientSolution();
	}

	@Test
	public void testTwoSum() {
		int [] result = twoSumEffientSolution.twoSum(new int[] {2,3,4,5}, 5);
		Assert.assertArrayEquals(new int[] {0, 1}, result);
	}
	
	@Test(expected = EmptyStackException.class)
	public void testTwoSumMethodNullArray() {
		twoSumEffientSolution.twoSum(null, 3);
	}

	@Test(expected = EmptyStackException.class)
	public void testTwoSumMethodEmptyArray() {
		twoSumEffientSolution.twoSum(new int[] {}, 3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTwoSumMethodSingleElementArray() {
		twoSumEffientSolution.twoSum(new int[] {1}, 3);
	}

	@Test
	public void testTwoSumMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "twoSum";
		Class<?> c = TwoSumEffientSolution.class;
		Method method = c.getDeclaredMethod(methodName, int[].class, int.class);
		Assert.assertNotNull(method);
	}
}
