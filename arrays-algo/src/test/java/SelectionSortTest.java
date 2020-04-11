import java.lang.reflect.Method;
import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SelectionSortTest {

	private SelectionSort selectionSort;

	@Before
	public void init() {
		selectionSort = new SelectionSort();
	}

	@Test(expected = EmptyStackException.class)
	public void selectionSortForNullArray() {
		selectionSort.selectionSort(null);
	}

	@Test(expected = EmptyStackException.class)
	public void selectionSortForEmptyArray() {
		selectionSort.selectionSort(new int[] {});
	}

	@Test
	public void selectionSort() {
		int[] array = selectionSort.selectionSort(new int[] { 1, 3, 2 });
		Assert.assertArrayEquals(array, new int[] { 1, 2, 3 });
	}

	@Test
	public void selectionSortNegitive() {
		int[] array = selectionSort.selectionSort(new int[] { -1, -3, -2 });
		Assert.assertArrayEquals(array, new int[] { -3, -2, -1 });
	}

	@Test
	public void selectionSortMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "selectionSort";
		Class<?> c = SelectionSort.class;
		Method method = c.getDeclaredMethod(methodName, int[].class);
		Assert.assertNotNull(method);
	}
}
