package sortingalgorithms;
import java.lang.reflect.Method;
import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sortingalgorithms.MergeSort;

public class MergeSortTest {
	private MergeSort mergeSort;

	@Before
	public void init() {
		mergeSort = new MergeSort();
	}

	@Test(expected = EmptyStackException.class)
	public void testMergeSortForNullArray() {
		mergeSort.mergeSort(null);
	}

	@Test(expected = EmptyStackException.class)
	public void testMergeSortForEmptyArray() {
		mergeSort.mergeSort(new int[] {});
	}

	@Test
	public void testMergeSortForOneElementArray() {
		int[] array = new int[] { 1 };
		mergeSort.mergeSort(array);
		Assert.assertArrayEquals(array, new int[] { 1 });
	}

	@Test
	public void testMergeSort() {
		int[] array = new int[] { 5, 4, 2, 3, 1 };
		mergeSort.mergeSort(array);
		Assert.assertArrayEquals(array, new int[] { 1, 2, 3, 4, 5 });
	}

	@Test
	public void testMergeSortNegativeNumber() {
		int[] array = new int[] { -1, -2, -3, -4, -5 };
		mergeSort.mergeSort(array);
		Assert.assertArrayEquals(array, new int[] { -5, -4, -3, -2, -1 });
	}

	@Test(expected = EmptyStackException.class)
	public void testMergeForEmptyArray() {
		mergeSort.merge(null, null, null);
	}

	@Test
	public void testMerge() {
		int[] array = new int[4];
		int[] left = new int[] { 2, 3 };
		int[] right = new int[] { 4, 5 };
		mergeSort.merge(array, left, right);
		Assert.assertArrayEquals(array, new int[] { 2, 3, 4, 5 });
	}

	@Test
	public void testMergeSortMethodExists() throws NoSuchMethodException, SecurityException {
		String methodName = "mergeSort";
		Class<?> c = MergeSort.class;
		Method method = c.getDeclaredMethod(methodName, int[].class);
		Assert.assertNotNull(method);
	}

	@Test
	public void testMergeMethodExists() throws NoSuchMethodException, SecurityException {
		String methodName = "merge";
		Class<?> c = MergeSort.class;
		Method method = c.getDeclaredMethod(methodName, int[].class, int[].class, int[].class);
		Assert.assertNotNull(method);
	}
}
