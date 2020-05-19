import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaskTest {
	private Task task = null;

	@Before
	public void init() {
		task = new Task();
	}

	@Test
	public void decode1() {
		Map<String, String> result = task.decode("s1=12&s2=11");
		Map<String, String> expected = new HashMap<>();
		expected.put("s1", "12");
		expected.put("s2", "11");
		Assert.assertEquals(expected, result);
	}

	@Test
	public void decode2() {
		Map<String, String> result = task.decode("s1=&s2=11");
		Map<String, String> expected = new HashMap<>();
		expected.put("s1", "");
		expected.put("s2", "11");
		Assert.assertEquals(expected, result);
	}

	@Test
	public void decode3() {
		Map<String, String> result = task.decode("s1=12&=11");
		Map<String, String> expected = new HashMap<>();
		expected.put("s1", "12");
		expected.put("", "11");
		Assert.assertEquals(expected, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void decode4() {
		Map<String, String> result = task.decode("s112&=11");
		Map<String, String> expected = new HashMap<>();
		expected.put("s1", "12");
		expected.put("", "11");
		Assert.assertEquals(expected, result);
	}

	@Test
	public void decode5() {
		Map<String, String> result = task.decode("");
		Map<String, String> expected = new HashMap<>();
		Assert.assertEquals(expected, result);
	}

	@Test
	public void decode6() {
		Map<String, String> result = task.decode(null);
		Assert.assertEquals(null, result);
	}

	@Test
	public void testDecodeMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "decode";
		Class<?> c = Task.class;
		Method method = c.getDeclaredMethod(methodName, String.class);
		Assert.assertNotNull(method);
	}
}
