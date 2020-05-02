package leetcode.arrays;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringRotationTest {
	private StringRotation stringRotation;

	@Before
	public void init() {
		stringRotation = new StringRotation();
	}
	
	@Test
	public void stringRotateTest4() {
		boolean result = stringRotation.stringRotate("abc", "cab");
		Assert.assertTrue(result);
	}
	
	@Test
	public void stringRotateTest3() {
		boolean result = stringRotation.stringRotate("abc", "cbad");
		Assert.assertFalse(result);
	}
	
	@Test
	public void stringRotateTest2() {
		boolean result = stringRotation.stringRotate(null, null);
		Assert.assertFalse(result);
	}

	@Test
	public void stringRotateTest1() {
		boolean result = stringRotation.stringRotate("", "");
		Assert.assertFalse(result);
	}

	@Test
	public void stringRotateMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "stringRotate";
		Class<?> c = StringRotation.class;
		Method method = c.getDeclaredMethod(methodName, String.class, String.class);
		Assert.assertNotNull(method);
	}
}
