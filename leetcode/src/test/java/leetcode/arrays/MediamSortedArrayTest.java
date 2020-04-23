package leetcode.arrays;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MediamSortedArrayTest {
	private MediamSortedArray mediam;

	@Before
	public void init() {
		mediam = new MediamSortedArray();
	}

	@Test
	public void testFindMedianSortedArrayForSingleElementArrays() {
		double mediam = this.mediam.findMedianSortedArrays(new int[] { 1 }, new int[] { 1 });
		Assert.assertEquals(mediam, 1.0, 0.0);
	}

	@Test
	public void testFindMedianSortedArrayForEmptyArrays() {
		double mediam = this.mediam.findMedianSortedArrays(new int[] {}, new int[] {});
		Assert.assertEquals(mediam, 0.0, 0.0);
	}

	@Test
	public void testFindMedianSortedArrayForNullValues() {
		double mediam = this.mediam.findMedianSortedArrays(null, null);
		Assert.assertEquals(mediam, 0.0, 0.0);
	}

	@Test
	public void testFindMedianSortedArray1() {
		double mediam = this.mediam.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 });
		Assert.assertEquals(mediam, 2.0, 0.0);
	}

	@Test
	public void testFindMedianSortedArray2() {
		double mediam = this.mediam.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3 , 4});
		Assert.assertEquals(mediam, 2.5, 0.0);
	}

	@Test
	public void testfindMedianSortedArraysMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "findMedianSortedArrays";
		Class<?> c = MediamSortedArray.class;
		Method method = c.getDeclaredMethod(methodName, int[].class, int[].class);
		Assert.assertNotNull(method);
	}
}
