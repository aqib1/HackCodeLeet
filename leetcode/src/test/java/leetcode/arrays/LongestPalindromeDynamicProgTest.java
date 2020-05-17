package leetcode.arrays;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestPalindromeDynamicProgTest {
	private LongestPalindromeDynamicProg test;
	
	@Before
	public void init() {
		test = new LongestPalindromeDynamicProg();
	}
	@Test
	public void logestPalindromeTest() {
		String data = test.longestPalindrome("babad");
		Assert.assertEquals(data, "bab");
	}
	@Test
	public void longestPalindromeMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "longestPalindrome";
		Class<?> c = LongestPalindromeDynamicProg.class;
		Method method = c.getDeclaredMethod(methodName, String.class);
		Assert.assertNotNull(method);
	}

}
