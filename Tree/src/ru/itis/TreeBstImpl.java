package ru.itis;

import java.util.ArrayList;

public class TreeBstImpl<T extends Comparable<T>> implements Tree<T> {
    class Node {
        private T value;
        private Node left;
        private Node right;
        private Node parent;

        Node(T value) {
            this.value = value;
        }
    }

    private Node root;

    public TreeBstImpl() {
        this.root = null;
    }

    public void insert(T value) {
        this.root = insert(root, value);
    }

    public void print() {
        print(root);
    }

    private void print(Node root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.value + " ");
            print(root.right);
        }
    }

    private Node insert(Node root, T value) {
        if (root == null) {
            root = new Node(value);
        } else if (value.compareTo(root.value) <= 0) {
            root.left = insert(root.left, value);
            root.left.parent = root;
        } else {
            root.right = insert(root.right, value);
            root.right.parent = root;
        }
        return root;
    }


    private Node minimum(Node root){
        Node current = root;
        while (current.left!=null){
            current = current.left;
        }
        return current;
    }

    //TODO:
    public boolean remove(T value) {
        Node node = find(value);
        Node parent = node.parent;     //предок удаляемого элемента
        if (node.left == null & node.right == null) { //удаляемый элемент - лист
            if (parent.left == node) {
                parent.left = null;
            }
            if (parent.right == node) {
                parent.right = null;
            }
            return true;
        } else {
            if (node.left == null | node.right == null) { //удаляемый элемент имеет одного потомка
                if (node.left == null) {
                    if (parent.left == node) {
                        parent.left = node.right;
                    } else {
                        parent.right = node.right;
                    }
                    node.right.parent = parent;
                } else {
                    if (parent.left == node) {
                        parent.left = node.left;
                    } else {
                        parent.right = node.left;
                    }
                    node.left.parent = parent;
                    return true;
                }
            } else {   //удаляемый элемент имеет двух потомков
                Node min = next(node);
                node.value = min.value;
                if (min.parent.left == min) {
                    min.parent.left = min.right;
                    if (min.right != null)
                        min.right.parent = min.parent;
                } else {
                    min.parent.right = min.right;
                    if (min.right != null)
                        min.right.parent = min.parent;
                }
                return true;
            }
        }
        return false;
    }

    private Node find(T value) {
        Node node = root;
        while (node != null) {
            if (node.value.compareTo(value) == 0) {
                return node;
            }
            if (node.value.compareTo(value) > 0) {
                node = node.left;
            }
            else {
                node = node.right;
            }
        }
        return null;
    }

    private Node next(Node node) { //поиск самого ближнего значения, которое меньше удаляемого
        if (node.right != null) {
            return minimum(node.right);
        }
        Node y = node.parent;
        while (y != null & node == y.right) {
            node = y;
            y = y.parent;
        }
        return y;
    }


    //TODO:
    public boolean contains(T value) {
        Node node = root;

        if (node == null)
            return false;

        while (node != null) {
            if (node.value.compareTo(value) == 0)
                return true;
            else if (node.value.compareTo(value) > 0)
                node = node.left;
            else
                node = node.right;
        }
        return false;
    }

    //TODO
    @Override
    public boolean isBst() {
        return isBst(root);
    }

    private boolean isBst(Node node) {
        if (node != null) {
            if ((node.left != null && node.value.compareTo(node.left.value) < 0) || (node.right != null && node.value.compareTo(node.right.value) >= 0)) {
                return false;
            } else {
                isBst(node.left);
                isBst(node.right);
            }
        }
        return true;
    }

    //TODO:
    public boolean equals(TreeBstImpl tree) {
        Node node = tree.root;
        Node newNode = root;
        return equals(node, newNode);
    }

    private boolean equals(Node node, Node newNode) {
        try {
            if (node == null & newNode == null) {
                return true;
            } else {
                if (node.value.compareTo(newNode.value) == 0) {
                    return equals(node.left, newNode.left) && equals(node.right, newNode.right);
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    ArrayList<ArrayList<T>> levels;
    @Override
    public void printByLevels() {
        levels =  new ArrayList<>();
        levels(root, 0);
        for (int i = 0; i < levels.size(); i++) {
            String sLevel = "";
            for (int j = 0; j < levels.get(i).size(); j++) {
                sLevel += String.valueOf(levels.get(i).get(j)) + " ";
            }
            if (sLevel != "") System.out.println(sLevel);
        }
    }

    private void levels(Node node, int level) {
        if (node != null) {
            if (!levels.contains(level)) levels.add(new ArrayList<T>());
            levels.get(level).add(node.value);
            level++;
            levels(node.left, level);
            levels(node.right, level);
        }
    }


}
