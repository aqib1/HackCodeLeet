package leetcode.arrays;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RepeatAndMissingNumberTest {

	private RepeatAndMissingNumber repeat;

	@Before
	public void init() {
		repeat = new RepeatAndMissingNumber();
	}
	
	@Test
	public void testRepeatedTest() {
		int[] result = repeat.repeatedNumber(new int[] {1, 2, 3, 3, 5});
		Assert.assertArrayEquals(result, new int[] {3, 4});
	}
	
	@Test
	public void testRepeatedTest1() {
		int[] result = repeat.repeatedNumber(new int[] {2, 2});
		Assert.assertArrayEquals(result, new int[] {2, 1});
	}

	@Test
	public void testRepeatedNumberNotNull() {
		int[] arr = repeat.repeatedNumber(null);
		Assert.assertArrayEquals(arr, new int[] {});
	}
	
	@Test
	public void testRepeatedNumberEmpty() {
		int[] arr = repeat.repeatedNumber(null);
		Assert.assertArrayEquals(arr, new int[] {});
	}

	@Test
	public void repeatedNumberMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "repeatedNumber";
		Class<?> c = RepeatAndMissingNumber.class;
		Method method = c.getDeclaredMethod(methodName, int[].class);
		Assert.assertNotNull(method);
	}
}
