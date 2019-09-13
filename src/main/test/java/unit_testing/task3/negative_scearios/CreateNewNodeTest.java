package unit_testing.task3.negative_scearios;

import org.junit.Test;
import tasks_for_weeks.exceptions.InvalidInputException;
import tasks_for_weeks.task3.TreeNode;


public class CreateNewNodeTest {
    @Test(expected = InvalidInputException.class)
    public void createNodeWithNullName() throws Exception {
        TreeNode root = new TreeNode(null);
    }
    @Test(expected = InvalidInputException.class)
    public void createNodeWithEmptyName() throws Exception {
        TreeNode root = new TreeNode("");
    }
}
