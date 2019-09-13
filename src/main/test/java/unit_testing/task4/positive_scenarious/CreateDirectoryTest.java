package unit_testing.task4.positive_scenarious;

import org.junit.Assert;
import org.junit.Test;
import tasks_for_weeks.task4.TreeNode;
import tasks_for_weeks.task4.Types;

import java.util.List;

public class CreateDirectoryTest {

    @Test
    public void showChildren() throws Exception {
        TreeNode treeNode = new TreeNode("root");

        TreeNode node1 = treeNode.addNode(new TreeNode("parentFolder"));
        TreeNode node2 = node1.addNode(new TreeNode("childFolder1"));
        TreeNode node3 = node1.addNode(new TreeNode("childFolder2"));
        TreeNode node4 = node1.addNode(new TreeNode("childFolder3.txt"));

        String path = "root/parentFolder";
        treeNode.showChildren(path);
        List<TreeNode> treeNodes = treeNode.getChildren(path);

        Assert.assertEquals(treeNode.getChildren(path).size(), 3);

        Assert.assertEquals(treeNodes.get(0).getName(), "childFolder1");
        Assert.assertEquals(treeNodes.get(0).getType(), Types.DIRECTORY);

        Assert.assertEquals(treeNodes.get(1).getName(), "childFolder2");
        Assert.assertEquals(treeNodes.get(1).getType(), Types.DIRECTORY);

        Assert.assertEquals(treeNodes.get(2).getName(), "childFolder3.txt");
        Assert.assertEquals(treeNodes.get(2).getType(), Types.FILE);

    }
}
