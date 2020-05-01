package generalbasicalgos;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCompressionTest {

	private StringCompression stringCompression;
	
	@Before
	public void init() {
		stringCompression = new StringCompression();
	}
	
	@Test
	public void testStringCompressionForEmpty() {
		String value = stringCompression.stringCompression("");
		Assert.assertEquals(value, "");
	}
	
	@Test
	public void testStringCompressionForNull() {
		String value = stringCompression.stringCompression(null);
		Assert.assertEquals(value, "");
	}
	
	@Test
	public void testStringCompression() {
		String value = stringCompression.stringCompression("aaabbbbc");
		Assert.assertEquals(value, "a3b4c1");
	}
	
	@Test
	public void stringCompressionMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "stringCompression";
		Class<?> c = StringCompression.class;
		Method method = c.getDeclaredMethod(methodName, String.class);
		Assert.assertNotNull(method);
	}
}
