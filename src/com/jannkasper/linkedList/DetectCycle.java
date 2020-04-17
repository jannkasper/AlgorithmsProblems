package com.jannkasper.linkedList;

/**
 * Detect  Cycle in alinked list (Floyd's Cycle Detection Algorithm)
 */
public class DetectCycle {

    public static boolean detectCycle (Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;

            if (slow == fast) {
                return true;
            }

            fast = fast.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }



    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1,2,3,4,5 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        head.next.next.next.next.next = head.next.next;

        if (detectCycle(head)) {
            System.out.println("Cycle Found");
        } else {
            System.out.println("No Cycle Found");
        }

    }
}
