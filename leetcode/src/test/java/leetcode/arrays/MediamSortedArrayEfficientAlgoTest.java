package leetcode.arrays;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MediamSortedArrayEfficientAlgoTest {

	private MediamSortedArrayEffcientAlgo median;

	@Before
	public void init() {
		median = new MediamSortedArrayEffcientAlgo();
	}

	@Test
	public void findMedianSortedArrayWithEmptyValues() {
		double median = this.median.findMedianSortedArrays(new int[] {}, new int[] {});
		Assert.assertEquals(median, 0);
	}

	@Test
	public void findMedianSortedArraysWithNullValues() {
		double median = this.median.findMedianSortedArrays(null, null);
		Assert.assertEquals(median, 0);
	}

	@Test
	public void findMedianSortedArraysTest() throws NoSuchMethodException, SecurityException {
		String methodName = "findMedianSortedArrays";
		Class<?> c = MediamSortedArrayEffcientAlgo.class;
		Method method = c.getDeclaredMethod(methodName, int[].class, int[].class);
		Assert.assertNotNull(method);
	}
}
