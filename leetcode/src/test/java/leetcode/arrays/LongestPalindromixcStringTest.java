package leetcode.arrays;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LongestPalindromixcStringTest {
	private LongestPalindromicString longestPalindromicString;
	
	@Before
	public void init() {
		longestPalindromicString = new LongestPalindromicString();
	}
	
	@Test
	public void logestPalindromeTest() {
		String data = longestPalindromicString.longestPalindrome("babad");
		Assert.assertEquals(data, "bab");
	}

	@Test
	public void longestPalindromeMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "longestPalindrome";
		Class<?> c = LongestPalindromicString.class;
		Method method = c.getDeclaredMethod(methodName, String.class);
		Assert.assertNotNull(method);
	}
}
