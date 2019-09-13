package tasks_for_weeks.task4;

import tasks_for_weeks.exceptions.InvalidInputException;
import tasks_for_weeks.exceptions.NodeNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree {
    private String path;

    public Tree(String path) throws InvalidInputException {
        if (path == null || path.isEmpty()) {
            throw new InvalidInputException("The path should not be empty");
        }
        this.path = path;
    }

    public List<TreeNode> buildTree() throws InvalidInputException, NodeNotFoundException {
        long startTime = System.currentTimeMillis();
        boolean fileIsCreated = false;

        List<String> list = new ArrayList<>(Arrays.asList(path.split("/")));
        List<TreeNode> nodes = new ArrayList<>();
        if (list.get(0).contains(".")) {
            throw new InvalidInputException("First of all you need create a folder and after file");
        }
        for (String node : list) {
            if (fileIsCreated) {
                throw new InvalidInputException("Illegal action! you can not create file inside of the file");
            }
            if (node.contains("..")) {
                throw new InvalidInputException("Invalid file format '" + node + "'");
            }
            if (node.contains(".")) {
                fileIsCreated = true;
            }
            nodes.add(new TreeNode(node));
        }
        for (int i = 1; i < nodes.size(); i++) {
            nodes.get(i - 1).addNode(nodes.get(i));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time for building tree in milli seconds is : " + (endTime - startTime));

        return nodes;
    }

    public void showTree(TreeNode treeNode) {
        treeNode.showTree();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
