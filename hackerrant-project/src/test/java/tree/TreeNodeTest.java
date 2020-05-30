package tree;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeNodeTest {

	private BinaryTreeTilt binaryTreeTilt;

	@Before
	public void init() {
		binaryTreeTilt = new BinaryTreeTilt();
	}

	@Test
	public void testFindTilt() {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		int result = binaryTreeTilt.findTilt(t1);
		Assert.assertTrue(result == 2);
	}

	@Test
	public void testFindTiltMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "findTilt";
		Class<?> c = BinaryTreeTilt.class;
		Method method = c.getDeclaredMethod(methodName, TreeNode.class);
		Assert.assertNotNull(method);
	}
}
