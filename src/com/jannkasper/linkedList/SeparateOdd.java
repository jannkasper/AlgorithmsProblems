package com.jannkasper.linkedList;

/**
 * 37. Rearrange a Linked List by Separating Odd Nodes from the Even Ones
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
 * Output: 2 -> 4 -> 6 -> 8 -> 10 -> 1 -> 3 -> 5 -> 7 -> 9
 */
public class SeparateOdd {

    public static Node rearrangeEvenOdd (Node frontHead, Node rest) {
        // we have reached the end of the list
        if (rest.next == null) return rest;

        // insert even number before unsorted rest
        if (rest.next.data%2 == 0) {
            Node temp = rest.next;
            rest.next = rest.next.next;
            temp.next = frontHead.next;
            frontHead.next = temp;

            // TIME COMPLEXITY O(n)
            rearrangeEvenOdd(frontHead.next, rest);
        } else {
            rearrangeEvenOdd(frontHead, rest.next);
        }
        return frontHead;
    }

    public static Node rearrangeEvenOdd (Node head) {
        if (head == null) return null;
        Node dummy = new Node(0, head);
        rearrangeEvenOdd(dummy, dummy);
        return dummy.next;
    }

    public static void main(String[] args) {
        // input keys
        int[] keys = { 1,2,3,4,5,6,7,8,9,10 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        head = rearrangeEvenOdd(head);

        // print result
        head.print();

    }
}
