package leetcode.arrays;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RotateImageTest {

	private RotateImage rotateImage;

	@Before
	public void init() {
		rotateImage = new RotateImage();
	}

	@Test
	public void testRotateImage() {
		int[][] result = rotateImage.rotateImage(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
		System.out.println(Arrays.deepToString(result));
		Assert.assertArrayEquals(result, new int[][] { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } });
	}

	@Test
	public void testRotateImageForEmptyArray() {
		int[][] result = rotateImage.rotateImage(new int[][] {});
		Assert.assertArrayEquals(result, new int[][] {});
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRotateImageForNullImage() {
		rotateImage.rotateImage(null);
	}

	@Test
	public void testRotateImageMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "rotateImage";
		Class<?> c = RotateImage.class;
		Method method = c.getDeclaredMethod(methodName, int[][].class);
		Assert.assertNotNull(method);
	}
}
