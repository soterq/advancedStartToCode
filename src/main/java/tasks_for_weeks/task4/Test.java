package tasks_for_weeks.task4;

public class Test {
    public static void main(String[] args) throws Exception {
        TreeNode treeNode = new TreeNode("root");

        TreeNode node1 = treeNode.addNode(new TreeNode("parentFolder"));
        TreeNode node2 = node1.addNode(new TreeNode("childFolder1"));
        TreeNode node3 = node1.addNode(new TreeNode("childFolder2"));
        TreeNode node4 = node1.addNode(new TreeNode("childFolder3.txt"));

        String path = "root/parentFolder";
        treeNode.showChildren(path);

        String root = "root";
        System.out.println();
        treeNode.showChildren(root);

    }
}
