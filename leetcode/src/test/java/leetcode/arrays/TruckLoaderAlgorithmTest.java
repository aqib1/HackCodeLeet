package leetcode.arrays;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TruckLoaderAlgorithmTest {

	private TruckLoaderAlgorithm truckLoaderAlgo;

	@Before
	public void init() {
		truckLoaderAlgo = new TruckLoaderAlgorithm();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void iDsOfPackagesTest7() {
		truckLoaderAlgo.idsOfPackages(20, Arrays.asList(1,2,3,4));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void iDsOfPackagesTest6() {
		truckLoaderAlgo.idsOfPackages(90, Arrays.asList());
	}

	@Test
	public void iDsOfPackagesTest4() {
		List<Integer> result = truckLoaderAlgo.idsOfPackages(90, Arrays.asList(1, 24, 26, 36, 34));
		Assert.assertTrue(result.get(0) == 1);
		Assert.assertTrue(result.get(1) == 3);
	}

	@Test
	public void iDsOfPackagesTest3() {
		List<Integer> result = truckLoaderAlgo.idsOfPackages(90, Arrays.asList(1, 25, 25, 35, 35));
		Assert.assertTrue(result.get(0) == 1);
		Assert.assertTrue(result.get(1) == 3);
	}

	@Test
	public void iDsOfPackagesTest1() {
		List<Integer> result = truckLoaderAlgo.idsOfPackages(90, Arrays.asList(1, 10, 25, 35, 60));
		Assert.assertTrue(result.get(0) == 2);
		Assert.assertTrue(result.get(1) == 3);
	}

	@Test
	public void iDsOfPackagesTest2() {
		List<Integer> result = truckLoaderAlgo.idsOfPackages(90, Arrays.asList(1, 25, 0, 35, 60));
		Assert.assertTrue(result.get(0) == 2);
		Assert.assertTrue(result.get(1) == 4);
	}

	@Test
	public void iDsOfPackagesTest5() {
		List<Integer> result = truckLoaderAlgo.idsOfPackages(90, Arrays.asList(1, 25, 35, 20, 40, 0, 60));
		Assert.assertTrue(result.get(0) == 5);
		Assert.assertTrue(result.get(1) == 6);
	}

	@Test
	public void iDsOfPackagesMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "idsOfPackages";
		Class<?> c = TruckLoaderAlgorithm.class;
		Method method = c.getDeclaredMethod(methodName, int.class, List.class);
		Assert.assertNotNull(method);
	}
}
