package com.jannkasper.linkedList;

class Node {
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

public class SortLinkedList {

    public static Node sortList(Node head) {
        Node root = head;
        Node beforeHead = null;
        Node current = head;
        Node beforeMin = head;
        Node min = head;

        while (current != null) {
            int m =0;
            while (current.next != null) {
                if (current.next.data <= min.data) {
                    min = current.next;
                    beforeMin = current;
                    m++;
                }
                current = current.next;
            }
            if (m == 0) {
                head = min.next;
                beforeHead = min;
                beforeMin = min;
                current = min.next;
                min = min.next;

                continue;
            }

            if (min.next == null) {
                beforeMin.next = null;
            } else {
                beforeMin.next = min.next;
            }

            if (beforeHead == null) {
                beforeHead = min;
                root = min;
            } else {
                beforeHead.next = min;
                beforeHead = min;
            }
            min.next = head;
            current = head;
            beforeMin = head;
            min = head;

        }
        return root;
    }

    public static void main(String[] args)
    {
        // input keys
//        int[] keys = { 1, 2, 0, 0, 1, 2, 1, 2, 1 };
        int[] keys = { 1,9,8,7,6,6,5,4,3,2 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        head = sortList(head);
        head.print();
    }
}

