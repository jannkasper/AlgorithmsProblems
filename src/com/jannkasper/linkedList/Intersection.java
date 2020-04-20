package com.jannkasper.linkedList;

/**
 * 19. Intersection of two given sorted linked lists
 * Input: { 1 -> 3 -> 4 -> 6 -> 7 -> 8 -> 9 -> 11 }, { 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 7 -> 10 -> 11 }
 * Output: 1 -> 3 -> 4 -> 7 -> 11
 */
public class Intersection {

    public static Node intersection (Node headA, Node headB) {
        Node head = new Node(0, null);
        Node tail = head;
        if (headA == null || headB == null) {
            return null;
        }

        // Until one or the other list not runs out
        // TIME COMPLEXITY O(n+m)
        do {
            if ( headA.data == headB.data) {
                tail = tail.next = new Node(headA.data, null);
                headA = headA.next;
                headB = headB.next;
            }
            else if (headA.data > headB.data) {
                headB = headB.next;
            }
            else if (headA.data < headB.data) {
                headA = headA.next;
            }
        } while (headA != null && headB != null);
        return head.next;
    }

    public static void main(String[] args) {
        // input keys
        int[] keysA = { 1,3,4,6,7,8,9,11};
        int[] keysB = { 0,1,2,3,4,5,7,10,11 };

        Node headA = null;
        for (int i = keysA.length - 1; i >= 0; i--) {
            headA = new Node(keysA[i], headA);
        }

        Node headB = null;
        for (int i = keysB.length - 1; i >= 0; i--) {
            headB = new Node(keysB[i], headB);
        }

        headA.print();
        headB.print();
        Node head = intersection(headA, headB);

        //print result
        head.print();
    }
}
