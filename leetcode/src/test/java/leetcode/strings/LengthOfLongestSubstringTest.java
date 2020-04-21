package leetcode.strings;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LengthOfLongestSubstringTest {
	private LengthOfLongestSubstring lengthOfLongestSubstring;

	@Before
	public void init() {
		lengthOfLongestSubstring = new LengthOfLongestSubstring();
	}

	@Test
	public void testUniqueSubStringWithNullValue() {
		List<String> values = lengthOfLongestSubstring.uniqueSubString(null);
		Assert.assertEquals(values.size(), 0);
	}

	@Test
	public void testUniqueSubStringWithEmptyValue() {
		List<String> values = lengthOfLongestSubstring.uniqueSubString("");
		Assert.assertEquals(values.size(), 0);
	}

	@Test
	public void lengthOfLongestSubstring() {
		int val = lengthOfLongestSubstring.lengthOfLongestSubstring("abc");
		Assert.assertTrue(val == 3);
	}

	@Test
	public void lengthOfLongestUniqueSubstring() {
		int val = lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcabb");
		Assert.assertTrue(val == 3);
	}

	@Test
	public void lengthOfLongestUniqueSubstring1() {
		int val = lengthOfLongestSubstring.lengthOfLongestSubstring("ab");
		Assert.assertTrue(val == 2);
	}

	@Test
	public void testUniqueSubString() {
		List<String> uniqueSubString = lengthOfLongestSubstring.uniqueSubString("abc");
		Assert.assertTrue(uniqueSubString.size() == 3);
	}

	@Test
	public void testUniqueSubStringMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "uniqueSubString";
		Class<?> c = LengthOfLongestSubstring.class;
		Method method = c.getDeclaredMethod(methodName, String.class);
		Assert.assertNotNull(method);
	}

	@Test
	public void lengthOfLongestSubstringWithNullSingleChar() {
		int val = lengthOfLongestSubstring.lengthOfLongestSubstring("a");
		Assert.assertTrue(val == 1);
	}

	@Test
	public void lengthOfLongestSubstringWithEmptyValue() {
		Assert.assertEquals(lengthOfLongestSubstring.lengthOfLongestSubstring(""), 0);
	}

	@Test
	public void lengthOfLongestSubstringWithNullValue() {
		Assert.assertEquals(lengthOfLongestSubstring.lengthOfLongestSubstring(null), 0);
	}

	@Test
	public void testLengthOfLongestSubstringMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "lengthOfLongestSubstring";
		Class<?> c = LengthOfLongestSubstring.class;
		Method method = c.getDeclaredMethod(methodName, String.class);
		Assert.assertNotNull(method);
	}
}
