package leetcode.arrays;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromeDynamicProgTest {

	@Test
	public void longestPalindromeMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "longestPalindrome";
		Class<?> c = LongestPalindromeDynamicProg.class;
		Method method = c.getDeclaredMethod(methodName, String.class);
		Assert.assertNotNull(method);
	}

}
