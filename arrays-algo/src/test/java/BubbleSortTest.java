import java.lang.reflect.Method;

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
	public void testBubbleSortMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "bubbleSort";
		Class<?> c = BubbleSort.class;
		Method method = c.getDeclaredMethod(methodName, int[].class);
		Assert.assertNotNull(method);
	}
}
