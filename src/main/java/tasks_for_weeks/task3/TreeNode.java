package tasks_for_weeks.task3;

import tasks_for_weeks.exceptions.InvalidInputException;
import tasks_for_weeks.exceptions.NodeNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private String name;
    private int level;
    private List<TreeNode> children;
    private TreeNode parent = null;
    //add path remove path

    public TreeNode(String name) throws InvalidInputException {
        if (name == null || name.isEmpty()) {
            throw new InvalidInputException("Node name can not be empty");
        }
        this.name = name;
        this.level = 0;
        this.children = new ArrayList<>();
    }

    public TreeNode addNode(TreeNode child) throws NodeNotFoundException {
        IsNull(child);
        child.setParent(this);
        child.setLevel(child.getParent().getLevel() + 1);
        this.children.add(child);
        return child;
    }

    public void removeNode() throws InvalidInputException {
       //verifica de la children
        if (parent == null) {
            throw new InvalidInputException("You can not delete the root");
        } else {
            this.parent.getChildren().remove(this);
        }
    }


  TreeNode findNode(String name) {
        for (TreeNode node : this.getChildren()) {
            if (node.getName().equals(name)) {
                return node;
            }
            TreeNode nestedNode = node.findNode(name);
            if (nestedNode != null) {
                return nestedNode;
            }
        }

        return null;
    }

    public int calculateDepth()   {
        return this.getLevel();
    }

    void showPath() {
        String s = "";
        TreeNode thisNode = this;
        while (thisNode.parent != null) {
            s = thisNode.getName() + "/" + s;
            thisNode = thisNode.parent;
        }
        s = thisNode.getName() + "/" + s;
        System.out.println(s);
    }


    public void showTree() {
        System.out.println(this.getName());
        for (TreeNode each : this.getChildren()) {
            showTree(each, " " + " ");
        }
    }

    private void showTree(TreeNode node, String appender) {
        System.out.println(appender + node.getName());
        for (TreeNode each : node.getChildren()) {
            showTree(each, appender + appender);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }

    private void IsNull(TreeNode node) throws NodeNotFoundException {
        if (node == null) {
            throw new NodeNotFoundException("Can not create new null node");
        }
    }

}
