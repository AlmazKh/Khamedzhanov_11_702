package ru.itis;

public class LinkedList<K, V> {
    public class Node {
        K key;
        V value;
        Node next;
        Node prev;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(K key, V value) {
        Node newNode = new Node(key, value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;

        }
        count++;
    }

    public Node get(int index) {
        Node node = head;
        while(index > 0) {
            node = node.next;
            index--;
        }
        return node;
    }

    public int size() {
        return count;
    }
}
