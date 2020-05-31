package tree;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnivaluedBTTest {
	private UnivaluedBT univaluedBT;

	@Before
	public void init() {
		univaluedBT = new UnivaluedBT();
	}

	@Test
	public void isUnivalTreeTest1() {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(1);
		t1.right = new TreeNode(1);

		Assert.assertTrue(univaluedBT.isUnivalTree(t1));
	}

	@Test
	public void isUnivalTreeTest2() {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(3);

		Assert.assertFalse(univaluedBT.isUnivalTree(t1));
	}

	@Test
	public void testIsUnivalTreeMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "isUnivalTree";
		Class<?> c = UnivaluedBT.class;
		Method method = c.getDeclaredMethod(methodName, TreeNode.class);
		Assert.assertNotNull(method);
	}
}
