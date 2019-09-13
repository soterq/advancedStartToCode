package unit_testing.task3.negative_scearios;

import org.junit.Assert;
import org.junit.Test;
import tasks_for_weeks.exceptions.InvalidInputException;
import tasks_for_weeks.exceptions.NodeNotFoundException;
import tasks_for_weeks.task3.TreeNode;

public class CalculateDeepTest {
    @Test(expected = NodeNotFoundException.class)
    public void calculateDeepForNullNode() throws NodeNotFoundException, InvalidInputException {
        TreeNode root = new TreeNode("root");

        TreeNode node1 = root.addNode(new TreeNode("node 1"));

        TreeNode node11 = root.addNode(new TreeNode("node 11"));

        TreeNode node111 = root.addNode(new TreeNode("node 111"));
        TreeNode node112 = node1.addNode(null);


       node112.calculateDepth();

    }
}
