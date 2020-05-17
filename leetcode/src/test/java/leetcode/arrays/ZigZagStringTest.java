package leetcode.arrays;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ZigZagStringTest {
	public ZigZagString zigZagString;
	
	@Before
	public void init() {
		zigZagString = new ZigZagString();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConvertWithNullString() {
		zigZagString.convert(null, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConvertWithEmptyString() {
		zigZagString.convert("", 1);
	}
	
	@Test
	public void testConvert() {
		String result = zigZagString.convert("PAYPALISHIRING", 3);
		Assert.assertEquals("PAHNAPLSIIGYIR", result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConvertWithNegitiveString() {
		zigZagString.convert("a", -1);
	}

	@Test
	public void testConvertMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "convert";
		Class<?> c = ZigZagString.class;
		Method method = c.getDeclaredMethod(methodName, String.class, int.class);
		Assert.assertNotNull(method);
	}
}
