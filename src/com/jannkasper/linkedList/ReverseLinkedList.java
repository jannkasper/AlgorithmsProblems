package com.jannkasper.linkedList;

/**
 * 20. Reverse a Linked List using Recursion
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6
 * Output: 6 -> 5 -> 4 -> 3 -> 2 -> 1
 */
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
        // return when reach end of linked list
        if ( head.next == null || head == null) {
            return head;
        }

        // return last node
        // TIME COMPLEXITY O(n)
        Node anotherHead = recursiveReverseList(head.next);

        // turn connection
        head.next.next = head;
        head.next = null;

        return anotherHead;
    }

    public static void main(String[] args) {
        // input keys
        int[] keys = { 1,2,3,4,5,6 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        head.print();
        head = recursiveReverseList(head);

        // print result
        head.print();

    }
}