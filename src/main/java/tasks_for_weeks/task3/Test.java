package tasks_for_weeks.task3;

import tasks_for_weeks.exceptions.InvalidInputException;
import tasks_for_weeks.exceptions.NodeNotFoundException;


public class Test {

    public static void main(String[] args) throws NodeNotFoundException, InvalidInputException {
        TreeNode root = new TreeNode("root");

        TreeNode anotherRoot = new TreeNode("disk D");

        TreeNode node1 = root.addNode(new TreeNode("node 1"));
        TreeNode node11 = node1.addNode(new TreeNode("node 11"));

        TreeNode node111 = node11.addNode(new TreeNode("node 111"));
        TreeNode node112 = node11.addNode(new TreeNode("node 112"));

        TreeNode node1121 = node112.addNode(new TreeNode("Node1121"));
        TreeNode node1122 = node112.addNode(new TreeNode("Node1122"));

        TreeNode node11221 = node1122.addNode(new TreeNode("Node11221"));

        TreeNode node12 = node1.addNode(new TreeNode("node 12"));

        TreeNode node2 = root.addNode(new TreeNode("node 2"));

        TreeNode node21 = node2.addNode(new TreeNode("node 21"));

        TreeNode node211 = node2.addNode(new TreeNode("node 211"));

        node11221.showPath();
        System.out.println(node11221.calculateDepth());
        System.out.println("##################################");
      TreeNode found = root.findNode("Node1122");
        System.out.println(found.getName() + " " +found.getLevel());

        System.out.println("##################################");
        root.showTree();
    }

}
