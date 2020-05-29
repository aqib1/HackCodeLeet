package amazon;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShortestSubSegmantTest {
	private ShortestSubSegmant shortestSubSegmant;

	@Before
	public void init() {
		shortestSubSegmant = new ShortestSubSegmant();
	}

	@Test
	public void testShortestSubSegment() {
		String result = shortestSubSegmant.shortestSubSegment(
				"This is a test. This is a programming test. This is a programming test in any language.", 4,
				new String[] { "this", "a", "test", "programming" });
		Assert.assertEquals("a programming test This", result);
	}

	@Test
	public void testShortestSubSegment1() {
		String result = shortestSubSegmant.shortestSubSegment(
				"This is a test. This is a programming test. This is a programming test in any language.", 4,
				new String[] { "this", "a", "test", "programing" });
		Assert.assertEquals("NO SUBSEGMENT FOUND", result);
	}

	@Test
	public void shortestSubSegmentMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "shortestSubSegment";
		Class<?> c = ShortestSubSegmant.class;
		Method method = c.getDeclaredMethod(methodName, String.class, int.class, String[].class);
		Assert.assertNotNull(method);
	}
}
