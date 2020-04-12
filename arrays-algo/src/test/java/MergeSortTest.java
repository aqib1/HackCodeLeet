import java.lang.reflect.Method;
import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


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
		int [] array = mergeSort.mergeSort(new int[] {1});
		Assert.assertArrayEquals(array, new int[] {1});
	}
	
	@Test
	public void testMergeSortMethodExists() throws NoSuchMethodException, SecurityException {
		String methodName = "mergeSort";
		Class<?> c = MergeSort.class;
		Method method = c.getDeclaredMethod(methodName, int[].class);
		Assert.assertNotNull(method);
	}
}
