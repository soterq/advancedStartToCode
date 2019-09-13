package unit_testing.task4.negative_scearios;

import org.junit.Test;
import tasks_for_weeks.exceptions.InvalidInputException;
import tasks_for_weeks.task4.TreeNode;

public class CreateDirectoryTest {
    @Test(expected = InvalidInputException.class)
    public void showPathFromDirectoryWithWrongPath() throws Exception {
        TreeNode treeNode = new TreeNode("root");

        TreeNode node1 = treeNode.addNode(new TreeNode("parentFolder"));
        TreeNode node2 = node1.addNode(new TreeNode("childFolder1"));
        TreeNode node3 = node1.addNode(new TreeNode("childFolder2"));
        TreeNode node4 = node1.addNode(new TreeNode("childFolder3.txt"));

        String path = "root/asda/parentFolder";
        treeNode.showChildren(path);

    }
}
