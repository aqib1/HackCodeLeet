package leetcode.strings;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LenghtOfLogestUniqueSubstrSlideWindowApproachTest {

	private LenghtOfLogestUniqueSubstrSlideWindowApproach approach;

	@Before
	public void init() {
		approach = new LenghtOfLogestUniqueSubstrSlideWindowApproach();
	}

	@Test
	public void testUniqueSubStringWithNullValue() {
		int value = approach.uniqueSubString(null);
		Assert.assertEquals(value, 0);
	}

	@Test
	public void testUniqueSubStringWithEmptyValue() {
		int value = approach.uniqueSubString("");
		Assert.assertEquals(value, 0);
	}

	@Test
	public void testUniqueSubStringWithSingleValue() {
		int value = approach.uniqueSubString("a");
		Assert.assertEquals(value, 1);
	}

	@Test
	public void testUniqueSubStringMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "uniqueSubString";
		Class<?> c = LenghtOfLogestUniqueSubstrSlideWindowApproach.class;
		Method method = c.getDeclaredMethod(methodName, String.class);
		Assert.assertNotNull(method);
	}

	@Test
	public void testUniqueSubString() {
		int value = approach.uniqueSubString("abb");
		Assert.assertEquals(value, 2);
	}

	@Test
	public void testUniqueSubString1() {
		int value = approach.uniqueSubString("abcdefgh");
		Assert.assertEquals(value, 8);
	}
	
	@Test
	public void testUniqueSubString2() {
		int value = approach.uniqueSubString("bbbbbb");
		Assert.assertEquals(value, 1);
	}
}
