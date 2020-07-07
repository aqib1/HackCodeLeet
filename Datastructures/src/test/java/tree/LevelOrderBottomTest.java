package tree;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LevelOrderBottomTest {
	private LevelOrderBottom levelOrderBottom;

	@Before
	public void init() {
		levelOrderBottom = new LevelOrderBottom();
	}

	@Test
	public void testLevelOrderBottom() {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		List<List<Integer>> expected = Arrays.asList(Arrays.asList(2, 3), Arrays.asList(1));
		List<List<Integer>> result = levelOrderBottom.levelOrderBottom(tree);
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testlevelOrderBottomMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "levelOrderBottom";
		Class<?> c = LevelOrderBottom.class;
		Method method = c.getDeclaredMethod(methodName, TreeNode.class);
		Assert.assertNotNull(method);
	}
}
