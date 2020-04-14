package sortingalgorithms;
import java.lang.reflect.Method;
import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sortingalgorithms.InsertionSort;

public class InsertionSortTest {

	private InsertionSort insertionSort;

	@Before
	public void init() {
		insertionSort = new InsertionSort();
	}

	@Test(expected = EmptyStackException.class)
	public void insertionSortNullArray() {
		insertionSort.insertionSort(null);
	}

	@Test(expected = EmptyStackException.class)
	public void insertionSortEmptyArray() {
		insertionSort.insertionSort(new int[] {});
	}

	@Test
	public void insertionSortSingleElementArray() {
		int[] array = insertionSort.insertionSort(new int[] { 1 });
		Assert.assertArrayEquals(array, new int[] { 1 });
	}

	@Test
	public void insertionSort() {
		int[] array = insertionSort.insertionSort(new int[] { 3, 2, 1 });
		Assert.assertArrayEquals(array, new int[] { 1, 2, 3 });
	}

	@Test
	public void insertionSortWithNegitiveValues() {
		int[] array = insertionSort.insertionSort(new int[] { -1, -2, -3 });
		Assert.assertArrayEquals(array, new int[] { -3, -2, -1 });
	}

	@Test
	public void insertionSortMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "insertionSort";
		Class<?> c = InsertionSort.class;
		Method method = c.getDeclaredMethod(methodName, int[].class);
		Assert.assertNotNull(method);
	}
}
