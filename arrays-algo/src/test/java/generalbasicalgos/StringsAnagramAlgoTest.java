package generalbasicalgos;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringsAnagramAlgoTest {

	private StringsAnagramAlgo stringsAnagramAlgo;

	@Before
	public void init() {
		stringsAnagramAlgo = new StringsAnagramAlgo();
	}

	@Test
	public void arePermutationTest8() {
		boolean result = stringsAnagramAlgo.arePermutation(null, null);
		Assert.assertFalse(result);
	}
	
	@Test
	public void arePermutationTest7() {
		boolean result = stringsAnagramAlgo.arePermutation(null, "bcba");
		Assert.assertFalse(result);
	}
	
	@Test
	public void arePermutationTest6() {
		boolean result = stringsAnagramAlgo.arePermutation("abc", null);
		Assert.assertFalse(result);
	}
	
	@Test
	public void arePermutationTest5() {
		boolean result = stringsAnagramAlgo.arePermutation("", "bcba");
		Assert.assertFalse(result);
	}
	
	@Test
	public void arePermutationTest4() {
		boolean result = stringsAnagramAlgo.arePermutation("abc", "");
		Assert.assertFalse(result);
	}
	
	@Test
	public void arePermutationTest3() {
		boolean result = stringsAnagramAlgo.arePermutation("abc", "bcba");
		Assert.assertFalse(result);
	}
	
	@Test
	public void arePermutationTest2() {
		boolean result = stringsAnagramAlgo.arePermutation("abc", "bcb");
		Assert.assertFalse(result);
	}

	@Test
	public void arePermutationTest1() {
		boolean result = stringsAnagramAlgo.arePermutation("abc", "bca");
		Assert.assertTrue(result);
	}

	@Test
	public void arePermutationMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "arePermutation";
		Class<?> c = StringsAnagramAlgo.class;
		Method method = c.getDeclaredMethod(methodName, String.class, String.class);
		Assert.assertNotNull(method);
	}
}
