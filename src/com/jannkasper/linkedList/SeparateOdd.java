package com.jannkasper.linkedList;

/**
 * Rearrange a Linked List by Separating Odd Nodes from the Even Ones
 */
public class SeparateOdd {

    public static Node rearrangeEvenOdd (Node even, Node rest) {
        if (rest.next == null) return rest;
        if (rest.next.data%2 == 0) {
            Node temp = rest.next;
            rest.next = rest.next.next;
            temp.next = even.next;
            even.next = temp;
            rearrangeEvenOdd(even.next, rest);
        } else {
            rearrangeEvenOdd(even, rest.next);
        }
        return even;
    }

    public static Node rearrangeEvenOdd (Node head) {
        if (head == null) return null;
        Node dummy = new Node(0, head);
        rearrangeEvenOdd(dummy, dummy);
        return dummy.next;
    }





    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1,2,3,4,5,6,7,8,9,10 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        head = rearrangeEvenOdd(head);
        head.print();

    }
}
