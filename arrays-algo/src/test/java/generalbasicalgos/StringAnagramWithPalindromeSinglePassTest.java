package generalbasicalgos;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class StringAnagramWithPalindromeSinglePassTest {
	private StringAnagramWithPalindromeSinglePass obj;
	
	@Before
	public void init() {
		obj = new StringAnagramWithPalindromeSinglePass();
	}

	@Test
	public void canPermutePalindromeTest1() {
		boolean result = obj.canPermutePalindrome(null);
		Assert.assertFalse(result);
	}
	
	@Test
	public void canPermutePalindromeTest2() {
		boolean result = obj.canPermutePalindrome("");
		Assert.assertFalse(result);
	}
	
	@Test
	public void canPermutePalindromeTest3() {
		boolean result = obj.canPermutePalindrome("a");
		Assert.assertTrue(result);
	}
	
	@Test
	public void canPermutePalindromeTest4() {
		boolean result = obj.canPermutePalindrome("aa");
		Assert.assertTrue(result);
	}
	
	@Test
	public void canPermutePalindromeTest5() {
		boolean result = obj.canPermutePalindrome("aabc");
		Assert.assertFalse(result);
	}
	
	@Test
	public void canPermutePalindromeTest6() {
		boolean result = obj.canPermutePalindrome("aabbb");
		Assert.assertTrue(result);
	}
	
	@Test
	public void canPermutePalindromeMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "canPermutePalindrome";
		Class<?> c = StringAnagramWithPalindromeSinglePass.class;
		Method method = c.getDeclaredMethod(methodName, String.class);
		Assert.assertNotNull(method);
	}
}
