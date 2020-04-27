package leetcode.arrays;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AmazonAirRoutesProblemTest {

	private AmazonAirRoutesProblem amazonAirRoutesProblem;

	@Before
	public void init() {
		amazonAirRoutesProblem = new AmazonAirRoutesProblem();
	}

	@Test
	public void getAirRoutesTest2() {
		List<int[]> result = amazonAirRoutesProblem.getAirRoutes(1, Arrays.asList(), Arrays.asList());
		Assert.assertArrayEquals(result.get(0), new int[] {});
	}

	@Test(expected = IllegalArgumentException.class)
	public void getAirRoutesTest1() {
		amazonAirRoutesProblem.getAirRoutes(1, null, null);
	}

	@Test
	public void getAirRoutesTest3() {
		List<int[]> result = amazonAirRoutesProblem.getAirRoutes(7000,
				Arrays.asList(new int[] { 1, 2000 }, new int[] { 2, 4000 }, new int[] { 3, 6000 }),
				Arrays.asList(new int[] { 1, 2000 }));
		Assert.assertArrayEquals(result.get(0), new int[] { 2, 1 });
	}

	@Test
	public void getAirRoutesTest5() {
		List<int[]> result = amazonAirRoutesProblem.getAirRoutes(7000,
				Arrays.asList(new int[] { 1, 2000 }, new int[] { 2, 4000 }, new int[] { 3, 6000 }),
				Arrays.asList(new int[] { 1, 2000 }, new int[] { 2, 2000 }));
		Assert.assertArrayEquals(result.get(0), new int[] { 2, 2 });
		Assert.assertArrayEquals(result.get(1), new int[] { 2, 1 });
	}

	@Test
	public void getAirRoutesTest6() {
		List<int[]> result = amazonAirRoutesProblem.getAirRoutes(7000,
				Arrays.asList(new int[] { 1, 2000 }, new int[] { 2, 4000 }, new int[] { 3, 6000 }),
				Arrays.asList(new int[] { 1, 2000 }, new int[] { 2, 2000 }, new int[] { 3, 1000 }));
		Assert.assertArrayEquals(result.get(0), new int[] { 3, 3 });
		Assert.assertTrue(result.size() == 1);
	}

	@Test
	public void getAirRoutesTest4() {
		List<int[]> result = amazonAirRoutesProblem.getAirRoutes(10000,
				Arrays.asList(new int[] { 1, 3000 }, new int[] { 2, 5000 }, new int[] { 3, 7000 },
						new int[] { 4, 10000 }),
				Arrays.asList(new int[] { 1, 2000 }, new int[] { 2, 3000 }, new int[] { 3, 4000 },
						new int[] { 4, 5000 }));
		Assert.assertArrayEquals(result.get(1), new int[] { 2, 4 });
		Assert.assertArrayEquals(result.get(0), new int[] { 3, 2 });
		Assert.assertTrue(result.size() == 2);
	}

	@Test
	public void getAirRoutesTest() throws NoSuchMethodException, SecurityException {
		String methodName = "getAirRoutes";
		Class<?> c = AmazonAirRoutesProblem.class;
		Method method = c.getDeclaredMethod(methodName, int.class, List.class, List.class);
		Assert.assertNotNull(method);
	}
}
