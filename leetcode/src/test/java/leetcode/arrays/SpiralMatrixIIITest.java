package leetcode.arrays;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SpiralMatrixIIITest {

	private SpiralMatrixIII spiralMatrixIII;
	
	@Before
	public void init() {
		spiralMatrixIII = new SpiralMatrixIII();
	}
	
	@Test
	public void testSprialMatrixIII() {
		int [][] result = spiralMatrixIII.spiralMatrixIII(3, 3, 1, 1);
		Assert.assertArrayEquals(result[0], new int[] {1,1});
		Assert.assertArrayEquals(result[1], new int[] {1,2});
		Assert.assertArrayEquals(result[2], new int[] {2,2});
	}
	
	@Test
	public void testSpiralMatrixIIIMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "spiralMatrixIII";
		Class<?> c = SpiralMatrixIII.class;
		Method method = c.getDeclaredMethod(methodName, int.class, int.class, int.class, int.class);
		Assert.assertNotNull(method);
	}
}
