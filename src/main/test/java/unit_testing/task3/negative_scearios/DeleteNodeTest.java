package unit_testing.task3.negative_scearios;

import org.junit.Test;
import tasks_for_weeks.exceptions.InvalidInputException;
import tasks_for_weeks.task3.TreeNode;

public class DeleteNodeTest {
    @Test(expected = InvalidInputException.class)
    public void deleteNode() throws Exception {
        TreeNode root = new TreeNode("root");

        TreeNode node1 = root.addNode(new TreeNode("node 1"));
        TreeNode node11 = root.addNode(new TreeNode("node 11"));
        root.removeNode();
    }
}
