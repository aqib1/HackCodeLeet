package leetcode.arrays;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeIntervalsTest {
	private MergeIntervals mergeIntervals;

	@Before
	public void init() {
		mergeIntervals = new MergeIntervals();
	}

	public void mergeTest() {
		int[][] merge = mergeIntervals.merge(new int[][] { { 1, 4 }, { 2, 3 } });
		Assert.assertArrayEquals(merge[0], new int[] { 1, 4 });
	}

	@Test
	public void testMergeMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "merge";
		Class<?> c = MergeIntervals.class;
		Method method = c.getDeclaredMethod(methodName, int[][].class);
		Assert.assertNotNull(method);
	}
}
