package algorithms;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RotateImage90Test {
	private RotateImage90 rotateImage90;

	@Before
	public void init() {
		rotateImage90 = new RotateImage90();
	}

	@Test
	public void rotateImage() {
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		a.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
		a.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
		a.add(new ArrayList<>(Arrays.asList(7, 8, 9)));
		rotateImage90.rotate(a);
		Assert.assertEquals(a, getRotatedArrayForTest());
	}

	private ArrayList<ArrayList<Integer>> getRotatedArrayForTest() {
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		a.add(new ArrayList<>(Arrays.asList(7, 4, 1)));
		a.add(new ArrayList<>(Arrays.asList(8, 5, 2)));
		a.add(new ArrayList<>(Arrays.asList(9, 6, 3)));
		return a;
	}

	@Test(expected = IllegalArgumentException.class)
	public void rotateImageWithNull() {
		rotateImage90.rotate(null);
	}

	@Test
	public void rotateImageMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "rotate";
		Class<?> c = RotateImage90.class;
		Method method = c.getDeclaredMethod(methodName, ArrayList.class);
		Assert.assertNotNull(method);
	}
}
