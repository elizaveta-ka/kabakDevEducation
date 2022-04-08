package com.company.Figures;

public class Array_list {
    private Node head;

    public Array_list() {
        this.head = null;
    }

    public class Node {
        public int data;
        public  Node next;

        public Node (int data) {
            this.data = data;
            next = null;
        }
    }
    public void add(int data) {
        Node newNode = new Node(data);
        Node currentNode = head;
        if (head == null) {
            head = newNode;
        } else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }
    public void remove (int data) {
        Node currentNode = head;
        Node preNode = null;

        while (currentNode.next != null) {

            if (currentNode.data == data) {
                if (currentNode == head) {
                    head = currentNode.next;
                } else {
                    preNode.next = currentNode.next;
                }
            }
            preNode = currentNode;
            currentNode = currentNode.next;
        }
    }
    public void print () {
        Node currentNode = head;

        if (head != null) {
            System.out.println(head.data);
        }
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            System.out.println(currentNode.data);
        }
    }
}
////    public Node(int info) {
////        this.info = info;
////    }
////    public Node() {}
////    public void display () {
////        System.out.println( this.info + "");
////    }
////}
////   public class Array {
////    Node head = new Node();