package generalbasicalgos;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringPermutationWithPalindromeTest {
	private StringPermutationWithPalindrome stringPermutationWithPalindrome;

	@Before
	public void init() {
		stringPermutationWithPalindrome = new StringPermutationWithPalindrome();
	}
	
	@Test
	public void canAnagramPalindromeTest0() {
		boolean result = stringPermutationWithPalindrome.canAnagramPalindrome("");
		Assert.assertFalse(result);
	}

	@Test
	public void canAnagramPalindromeTest1() {
		boolean result = stringPermutationWithPalindrome.canAnagramPalindrome("aba");
		Assert.assertTrue(result);
	}
	
	@Test
	public void canAnagramPalindromeTest2() {
		boolean result = stringPermutationWithPalindrome.canAnagramPalindrome("abac");
		Assert.assertFalse(result);
	}
	
	@Test
	public void canAnagramPalindromeTest3() {
		boolean result = stringPermutationWithPalindrome.canAnagramPalindrome("abab");
		Assert.assertTrue(result);
	}
	
	@Test
	public void canAnagramPalindromeTest4() {
		boolean result = stringPermutationWithPalindrome.canAnagramPalindrome(null);
		Assert.assertFalse(result);
	}

	@Test
	public void canAnagramPalindromeMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "canAnagramPalindrome";
		Class<?> c = StringPermutationWithPalindrome.class;
		Method method = c.getDeclaredMethod(methodName, String.class);
		Assert.assertNotNull(method);
	}
}
