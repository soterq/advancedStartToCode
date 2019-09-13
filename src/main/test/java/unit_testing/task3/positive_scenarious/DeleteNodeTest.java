package unit_testing.task3.positive_scenarious;

import org.junit.Assert;
import org.junit.Test;
import tasks_for_weeks.task3.TreeNode;


public class DeleteNodeTest {
    @Test
    public void deleteNode() throws Exception {
        TreeNode root = new TreeNode("root");

        TreeNode node1 = root.addNode(new TreeNode("node 1"));
        TreeNode node11 = root.addNode(new TreeNode("node 11"));

        TreeNode subNode1 = node1.addNode(new TreeNode("subNode1"));
        TreeNode subNode11 = node1.addNode(new TreeNode("subNode11"));

        root.showTree();
        int size = node1.getChildren().size();
        subNode11.removeNode();
        root.showTree();

        Assert.assertNotEquals(node1.getChildren().size(), size);

    }
}
