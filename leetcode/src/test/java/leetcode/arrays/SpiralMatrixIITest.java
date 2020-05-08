package leetcode.arrays;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpiralMatrixIITest {
	
	private SpiralMatrixII spiralMatrixII;
	
	@Before
	public void init() {
		spiralMatrixII = new SpiralMatrixII();
	}
	
	@Test
	public void testGenerateMatrix() {
		int[][] result = spiralMatrixII.generateMatrix(3);
		System.out.println(Arrays.deepToString(result));
	}

	 @Test
	 public void testGenerateMatrixMethod() throws NoSuchMethodException, SecurityException {
			String methodName = "generateMatrix";
			Class<?> c = SpiralMatrixII.class;
			Method method = c.getDeclaredMethod(methodName, int.class);
			Assert.assertNotNull(method);
	 	}
}
