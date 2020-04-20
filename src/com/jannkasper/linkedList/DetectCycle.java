package com.jannkasper.linkedList;

/**
 * 31. Detect  Cycle in alinked list (Floyd's Cycle Detection Algorithm)
 * Input: { 1, 2, 3, 4, 5 }
 * Output: Cycle Found
 */
public class DetectCycle {

    public static boolean detectCycle (Node head) {
        // create two pointers
        Node slow = head;
        Node fast = head;

        // iterate thru cycle by two pointers with different speed
        // TIME COMPLECITY O(n)
        while (fast != null && fast.next != null) {
            fast = fast.next;

            // compare values after first fast step
            if (slow == fast) {
                return true;
            }

            fast = fast.next;
            slow = slow.next;

            // compare values after second fast step
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // input keys
        int[] keys = { 1,2,3,4,5 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        head.next.next.next.next.next = head.next.next;

        // print result
        if (detectCycle(head)) {
            System.out.println("Cycle Found");
        } else {
            System.out.println("No Cycle Found");
        }
    }
}
