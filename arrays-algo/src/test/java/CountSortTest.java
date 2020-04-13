import java.lang.reflect.Method;
import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountSortTest {

	private CountSort countSort = null;

	@Before
	public void init() {
		countSort = new CountSort();
	}

	@Test(expected = EmptyStackException.class)
	public void testCountSortWithNullArray() {
		countSort.countSort(null);
	}

	@Test(expected = EmptyStackException.class)
	public void testCountSortWithEmptyArray() {
		countSort.countSort(new int[] {});
	}

	@Test
	public void testCountSortWithSingleArray() {
		int[] array = countSort.countSort(new int[] { 1 });
		Assert.assertArrayEquals(new int[] { 1 }, array);
	}

	@Test
	public void testCountSort() {
		int[] array = countSort.countSort(new int[] { 3, 2, 1, 1, 5 });
		Assert.assertArrayEquals(new int[] { 1, 1, 2, 3, 5 }, array);
	}

	@Test
	public void testCountSortMethodExists() throws NoSuchMethodException, SecurityException {
		String methodName = "countSort";
		Class<?> c = CountSort.class;
		Method method = c.getDeclaredMethod(methodName, int[].class);
		Assert.assertNotNull(method);
	}
}
