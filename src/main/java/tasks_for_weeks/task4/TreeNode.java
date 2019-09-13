package tasks_for_weeks.task4;

import tasks_for_weeks.exceptions.InvalidInputException;
import tasks_for_weeks.exceptions.NodeNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNode {
    private String name;
    private Types type;
    private String path;
    private List<TreeNode> children;


    public TreeNode(String name) throws InvalidInputException {
        if (name == null || name.isEmpty()) {
            throw new InvalidInputException("Node name can not be empty");
        }
        this.name = name;
        this.children = new ArrayList<>();
        this.type = Types.DIRECTORY;
    }

    public TreeNode addNode(TreeNode child) throws NodeNotFoundException, InvalidInputException {
        nodeIsNull(child);
        fileTapeValidation(child);
        if (child.getName().contains(".")) {
            child.setType(Types.FILE);
        }
        this.children.add(child);
        child.setPath(this.getPath() + "/" + child.getName());
        return child;
    }


    public void showChildren(String path) throws Exception {
        List<TreeNode> childrenList = getChildren(path);
        for (TreeNode treeNode : childrenList) {
            System.out.println(treeNode.getName() + "   " + treeNode.getType());
        }
    }


   public List<TreeNode> getChildren(String path) throws Exception {
        if (path == null || path.isEmpty()) {
            throw new InvalidInputException("path should be not empty or null");
        }
        List<String> list = new ArrayList<>(Arrays.asList(path.split("/")));

        if (list.size() == 1 ) {
          if(!list.get(0).equals(this.getName())){
              throw new InvalidInputException("This folder do not exist");
            }
            return this.getChildren();
        }

        TreeNode node;
        for (int i = 1; i < list.size(); i++) {
            if (i == list.size() - 1) {
                node = getChild(list.get(list.size() - 1));

                if (node == null) {
                    System.out.println("this folder is empty");
                    return null;
                }
                return node.getChildren();
            }
            node = getChild(list.get(i));
            if (node == null) {
                throw new InvalidInputException("Entered path is invalid");
            }
        }
        return null;
    }


    TreeNode getChild(String name) {
        for (TreeNode node : this.getChildren()) {
            if (node.getName().equals(name)) {
                return node;
            }
        }
        return null;
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


    private void nodeIsNull(TreeNode node) throws NodeNotFoundException {
        if (node == null) {
            throw new NodeNotFoundException("Can not add null node!");
        }
    }

    void showTree() {
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

    private void fileTapeValidation(TreeNode child) throws InvalidInputException {
        int count = name.length() - name.replace(".", "").length();
        if (count > 1) {
            throw new InvalidInputException("You enter invalid file format : file format should be fileName.type");
        }
        if (child.getName().substring(child.getName().length() - 1).equals(".")) {
            throw new InvalidInputException("You enter invalid file format : file format should be fileName.type");
        }
        if (!child.getName().contains(".")) {
            child.setType(Types.DIRECTORY);
        } else {
            child.setType(Types.FILE);
        }
    }

    public String getPath() {
        if (path == null) {
            return this.getName();
        }
        return path;
    }

    public void setPath(String path) {

        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }


}
