package com.jannkasper.linkedList;

public class Node {
    int data;
    Node next;

    public Node(int value, Node next) {
        this.data = value;
        this.next = next;
    }

    public void print() {
        Node current = this;
        while(current.next != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print(current.data);
        System.out.println();
    }
}
