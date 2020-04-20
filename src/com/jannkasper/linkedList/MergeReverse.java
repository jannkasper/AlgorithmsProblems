package com.jannkasper.linkedList;

/**
 * 25. Merge two sorted linked losts from their end
 * Input: { 2 -> 4 -> 6 }, { 1 -> 3 -> 5 -> 7 -> 9 }
 * Output: 9 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1
 */
public class MergeReverse {

    public static Node mergeReverse (Node headA, Node headB) {
        Node head = null;
        Node temp = null;

        // TIME COMPLEXITY O(n+m)
        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                // take the node from the front of list a, and move it to the front of the result
                temp = headA;
                headA = headA.next;
                temp.next = head;
                head = temp;
            } else {
                // take the node from the front of list b, and move it to the front of the result
                temp = headB;
                headB = headB.next;
                temp.next = head;
                head = temp;
            }
        }

        // TIME COMPLEXITY O(n)
        while (headA != null) {
            temp = headA;
            headA = headA.next;
            temp.next = head;
            head = temp;
        }

        // TIME COMPLEXITY O(m)
        while (headB != null) {
            temp = headB;
            headB = headB.next;
            temp.next = head;
            head = temp;
        }

        return head;
    }



    public static void main(String[] args) {
        // input keys
        int[] keysA = { 2,4,6 };
        int[] keysB = { 1,3,5,7,9 };

        Node headA = null;
        for (int i = keysA.length - 1; i >= 0; i--) {
            headA = new Node(keysA[i], headA);
        }

        Node headB = null;
        for (int i = keysB.length - 1; i >= 0; i--) {
            headB = new Node(keysB[i], headB);
        }

        // print result
        headA.print();
        headB.print();
        Node head = mergeReverse(headA, headB);
        head.print();

    }
}
