package generalbasicalgos;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringPermutationsTest {

	private StringPermutations stringPermutations;

	@Before
	public void init() {
		stringPermutations = new StringPermutations();
	}

	@Test
	public void permutationsTest() {
		List<String> li = stringPermutations.permutations("abc");
		Assert.assertTrue(li.size() == 6);
		Assert.assertEquals(li.get(0), "abc");
		Assert.assertEquals(li.get(1), "acb");
		Assert.assertEquals(li.get(2), "bac");
	}
	
	@Test
	public void permutationsTestWithNullString() {
		List<String> li = stringPermutations.permutations(null);
		Assert.assertTrue(li.isEmpty());
	}
	
	@Test
	public void permutationsTestWithEmptyString() {
		List<String> li = stringPermutations.permutations("");
		Assert.assertTrue(li.isEmpty());
	}

	@Test
	public void permutationsMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "permutations";
		Class<?> c = StringPermutations.class;
		Method method = c.getDeclaredMethod(methodName, String.class);
		Assert.assertNotNull(method);
	}
}
