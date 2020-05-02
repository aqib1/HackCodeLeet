package leetcode.arrays;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RotateImageLinearSolutionTest {

	private RotateImageLinearSolution rotate;
	
	@Before
	public void init() {
		rotate = new RotateImageLinearSolution();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void rotateImageWithNullArray() {
		rotate.rotateImage(null);
	}
	
	@Test
	public void rotateImageTest() {
		int [][]image = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate.rotateImage(image);
		Assert.assertArrayEquals(image, new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}});
	}
	
	@Test
	public void rotateImageMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "rotateImage";
		Class<?> c = RotateImageLinearSolution.class;
		Method method = c.getDeclaredMethod(methodName, int[][].class);
		Assert.assertNotNull(method);
	}
}
