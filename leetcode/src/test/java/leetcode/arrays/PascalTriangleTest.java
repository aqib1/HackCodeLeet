package leetcode.arrays;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PascalTriangleTest {
	private PascalTriangle pascalTriangle;
	
	@Before
	public void init() {
		pascalTriangle = new PascalTriangle();
	}

	@Test
	public void testGenerate() {
		List<List<Integer>> r = pascalTriangle.generate(3);
		Assert.assertTrue(r.get(0).get(0) == 1);
		Assert.assertTrue(r.get(1).get(0) == 1);
		Assert.assertTrue(r.get(1).get(1) == 1);
		Assert.assertTrue(r.get(2).get(1) == 2);
	}
	
	@Test
	public void testGenerateMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "generate";
		Class<?> c = PascalTriangle.class;
		Method method = c.getDeclaredMethod(methodName, int.class);
		Assert.assertNotNull(method);
	}
}
