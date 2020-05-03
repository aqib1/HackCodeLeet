package algorithms;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxSumUsingEfficientKadaneTest {
	private MaxSumUsingEfficientKadane max;
	
	@Before
	public void init() {
		max = new MaxSumUsingEfficientKadane();
	}
	
	@Test
	public void maxSubArray() {
		int result = max.maxSubArray(new int[] {1, -3, 2, 1, -1});
		Assert.assertEquals(result, 3);
		
		 result = max.maxSubArrayOn2(new int[] {1, -3, 2, 1, -1});
		Assert.assertEquals(result, 3);
	}
	
	@Test
	public void maxSubArrayWithNull() {
		int result = max.maxSubArray(null);
		Assert.assertEquals(result, -1);
	}
	

	@Test
	public void maxSubArrayMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "maxSubArray";
		Class<?> c = MaxSumUsingEfficientKadane.class;
		Method method = c.getDeclaredMethod(methodName, int[].class);
		Assert.assertNotNull(method);
	}
}
