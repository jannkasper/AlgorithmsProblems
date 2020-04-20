package com.jannkasper.linkedList;

/**
 * 30. Sort linked list
 * Input: 1 -> 9 -> 8 -> 7 -> 6 -> 6 -> 5 -> 4 -> 3 -> 2
 * Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 6 -> 7 -> 8 -> 9
 */
public class SortLinkedList {

    public static Node sortList(Node head) {
        Node root = head;
        Node beforeHead = null;
        Node current = head;
        Node beforeMin = head;
        Node min = head;

        // TIME COMPLEXITY O(n)
        while (current != null) {
            int m =0;

            // find node with minimum value
            // TIME COMPLEXITY O(n)
            while (current.next != null) {
                if (current.next.data <= min.data) {
                    min = current.next;
                    beforeMin = current;
                    m++;
                }
                current = current.next;
            }

            // cover situation when head Node has a minimum value
            if (m == 0) {
                head = min.next;
                beforeHead = min;
                beforeMin = min;
                current = min.next;
                min = min.next;

                continue;
            }

            // move minimum node node to the front
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

            // move current head one step forward
            min.next = head;
            current = head;
            beforeMin = head;
            min = head;

        }
        return root;
    }

    public static void main(String[] args) {
        // input keys
        int[] keys = { 1,9,8,7,6,6,5,4,3,2 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        head = sortList(head);

        // print result
        head.print();
    }
}

