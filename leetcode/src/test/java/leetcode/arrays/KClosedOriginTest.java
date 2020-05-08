package leetcode.arrays;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KClosedOriginTest {
	private KClosedToOrigin kClosedToOrigin;

	@Before
	public void init() {
		kClosedToOrigin = new KClosedToOrigin();
	}

	@Test
	public void testKClosedToOrigin() {
		int[][] r = kClosedToOrigin.kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1);
		Assert.assertArrayEquals(r[0], new int[] { -2, 2 });
	}

	@Test
	public void kClosestMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "kClosest";
		Class<?> c = KClosedToOrigin.class;
		Method method = c.getDeclaredMethod(methodName, int[][].class, int.class);
		Assert.assertNotNull(method);
	}
}
