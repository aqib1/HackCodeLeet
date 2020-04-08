import java.lang.reflect.Method;
import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {

	private BubbleSort bubbleSort;

	@Before
	public void init() {
		bubbleSort = new BubbleSort();
	}

	@Test
	public void testBubbleSortForOneElement() {
		int[] array = bubbleSort.bubbleSort(new int[] { 2 });
		Assert.assertArrayEquals(array, new int[] { 2 });
	}

	@Test(expected = EmptyStackException.class)
	public void testBubbleSortForNullArray() {
		bubbleSort.bubbleSort(null);
	}

	@Test(expected = EmptyStackException.class)
	public void testBubbleSortForEmptyArray() {
		bubbleSort.bubbleSort(new int[] {});
	}

	@Test
	public void testBubbleSortMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "bubbleSort";
		Class<?> c = BubbleSort.class;
		Method method = c.getDeclaredMethod(methodName, int[].class);
		Assert.assertNotNull(method);
	}
}
