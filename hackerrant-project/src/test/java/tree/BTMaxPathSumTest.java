package tree;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class BTMaxPathSumTest {

	private BTMaxPathSum bTMaxPathSum;

	@Before
	public void init() {
		bTMaxPathSum = new BTMaxPathSum();
	}

	@Test
	public void maxPathSum() {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		Assert.assertTrue(6 == bTMaxPathSum.maxPathSum(treeNode));
	}

	@Test
	public void testMaxPathSumMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "maxPathSum";
		Class<?> c = BTMaxPathSum.class;
		Method method = c.getDeclaredMethod(methodName, TreeNode.class);
		Assert.assertNotNull(method);
	}
}
