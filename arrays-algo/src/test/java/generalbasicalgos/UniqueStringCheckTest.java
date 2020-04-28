package generalbasicalgos;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UniqueStringCheckTest {
	private UniqueStringCheck uniqueStringCheck;

	@Before
	public void init() {
		uniqueStringCheck = new UniqueStringCheck();
	}
	
	@Test
	public void isUniqueStringTest1() {
		boolean ans = uniqueStringCheck.isUniqueString("abc");
		Assert.assertTrue(ans);
	}
	
	@Test
	public void isUniqueStringTest2() {
		boolean ans = uniqueStringCheck.isUniqueString("abca");
		Assert.assertFalse(ans);
	}
	
	@Test
	public void isUniqueStringTest4() {
		boolean ans = uniqueStringCheck.isUniqueString("abc$$");
		Assert.assertFalse(ans);
	}

	@Test
	public void isUniqueStringTest3() {
		boolean ans = uniqueStringCheck.isUniqueString("abc$#");
		Assert.assertTrue(ans);
	}

	@Test(expected = IllegalArgumentException.class)
	public void isUniqueStringForNullString() {
		uniqueStringCheck.isUniqueString(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void isUniqueStringForEmptyString() {
		uniqueStringCheck.isUniqueString("");
	}

	@Test
	public void isUniqueStringMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "isUniqueString";
		Class<?> c = UniqueStringCheck.class;
		Method method = c.getDeclaredMethod(methodName, String.class);
		Assert.assertNotNull(method);
	}
}
