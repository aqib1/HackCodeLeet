package algorithms;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxSumContigousSubArrayTest {

	private MaxSumContigousSubArray maxSumContigousSubArray;
	
	@Before
	public void init() {
		maxSumContigousSubArray = new MaxSumContigousSubArray();
	}
	
	@Test
	public void maxSubArray() {
		int result = maxSumContigousSubArray.maxSubArray(new int[] {1, -3, 2, 1, -1});
		Assert.assertEquals(result, 3);
	}
	
	@Test
	public void maxSubArrayWithNull() {
		int result = maxSumContigousSubArray.maxSubArray(null);
		Assert.assertEquals(result, -1);
	}
	
	
	@Test
	public void maxSubArrayMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "maxSubArray";
		Class<?> c = MaxSumContigousSubArray.class;
		Method method = c.getDeclaredMethod(methodName, int[].class);
		Assert.assertNotNull(method);
	}
}
