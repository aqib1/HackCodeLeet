package leetcode.strings;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringPermutationsTest {

	private StringPermutations perm = null;

	@Before
	public void init() {
		perm = new StringPermutations();
	}

	@Test
	public void testPermutations() {
		List<String> result = perm.permutation("abc");
		List<String> expected = Arrays.asList("abc", "acb", "bac", "bca", "cba", "cab");
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testPermutationMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "permutation";
		Class<?> c = StringPermutations.class;
		Method method = c.getDeclaredMethod(methodName, String.class);
		Assert.assertNotNull(method);
	}
}
