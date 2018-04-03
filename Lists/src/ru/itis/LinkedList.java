package ru.itis;


public class LinkedList implements List {

    private static class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }
    // ссылка на первый элемент списка
    private Node head;
    // ссылка на последний элемент списка
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public Object get(int index) {
        Node node = head;
        while(index > 0) {
            node = node.next;
            index--;
        }
        return node.value;
    }

    @Override
    public void addToBegin(Object object) {
        Node newNode = new Node(object);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    @Override
    public void add(Object element) {
        Node newNode = new Node(element);
        tail.next = newNode;
        tail = newNode;
    }

    @Override
    public void remove(Object element) {
        if (head.value == element) {
            head = head.next;
            return;
        }

        Node node = head;
        Node node2 = head;

       /*if (tail.value.equals(element)) {
           while (node2 != tail) {
               *//*if (node2.value == element) {
                   node.next = null;
                   return;
               }*//*
               node = node.next;
               node2 = node.next;
           }
           node2.next = null;
           return;
       }*/
            while (node2 != null) {
                if (node2.value == element) {
                    if(node2.equals(tail)) {
                        node.next = null;
                        tail = node;
                        return;
                    }
                    node.next = node2.next;
                    return;
                }
                node = node.next;
                node2 = node.next;
            }
        }


    @Override
    public boolean contains(Object element) {
        Node newNode = this.head;
        while ( newNode != this.tail) {
            if( newNode == element) {
                return true;
            }
            newNode = newNode.next;
        }
        return false;
    }

    public void reverse() {
      /*  Node node = head;
        int count = 0;
        while( node != tail) {
            count++;
            node = node.next;
        }*/

        Node newNode = head;
        Node newNode2 = newNode.next;
        Node newNode3 = newNode2.next;

        newNode.next = null;
        while ( newNode2 != tail) {
            newNode2.next = newNode;
            newNode = newNode2;
            newNode2 = newNode3;
            newNode3 = newNode3.next;
        }
        newNode2.next = newNode;
        newNode = head;
        head = tail;
        tail = newNode;

    }
}