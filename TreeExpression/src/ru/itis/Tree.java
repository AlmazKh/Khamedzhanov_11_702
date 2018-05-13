package ru.itis;

public class Tree<T extends Comparable<T>> {
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

    public Tree(Node root) {
        this.root = root;
    }

    public void insert(T value) {
        this.root = insert(root, value);
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
}
