package tree;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrintBinaryTreeIn2DTest {
	private PrintBinaryTreeIn2D printBinaryTreeIn2D;

	@Before
	public void init() {
		printBinaryTreeIn2D = new PrintBinaryTreeIn2D();
	}

	@Test
	public void testPrintTree() {
		TreeNode t1 = new TreeNode(3);
		t1.left = new TreeNode(1);
		t1.right = new TreeNode(5);
		List<List<String>> result = printBinaryTreeIn2D.printTree(t1);
		Assert.assertEquals(Arrays.asList("", "3", ""), result.get(0));
		Assert.assertEquals(Arrays.asList("1", "", "5"), result.get(1));
	}

	@Test
	public void testPrintTreeMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "printTree";
		Class<?> c = PrintBinaryTreeIn2D.class;
		Method method = c.getDeclaredMethod(methodName, TreeNode.class);
		Assert.assertNotNull(method);
	}
}
