package com.jannkasper.linkedList;

public class ReverseLinkedList {

    public static Node reverseList (Node head) {
        Node anotherHead = null;
        while (head != null) {
            Node temp = head.next;
            head.next = anotherHead;
            anotherHead = head;
            head = temp;
        }
        return anotherHead;
    }

    public static Node recursiveReverseList (Node head) {
        if ( head.next == null || head == null) {
            return head;
        }
        Node anotherHead = recursiveReverseList(head.next);
        head.next.next = head;
        head.next = null;

        return anotherHead;
    }

    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1,2,3,4,5,6 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        head.print();
        head = recursiveReverseList(head);
        head.print();

    }
}