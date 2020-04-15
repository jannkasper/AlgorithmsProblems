package com.jannkasper.linkedList;

/**
 * Merge two sorted linked lists from their end
 */
public class MergeSorted {

    public static Node mergeRecursive (Node headA, Node headB) {
        Node head = null;
        Node temp;
        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                 temp = headA.next;
                 headA.next = head;
                 head = headA;
                 headA = temp;
            } else {
                temp = headB.next;
                headB.next = head;
                head = headB;
                headB = temp;
            }
        }

        while (headA != null){
            temp = headA.next;
            headA.next = head;
            head = headA;
            headA = temp;
        }
        while (headB != null){
            temp = headB.next;
            headB.next = head;
            head = headB;
            headB = temp;
        }
        return head;
    }



    public static void main(String[] args)
    {
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

        headA.print();
        headB.print();
        Node head = mergeRecursive(headA, headB);
        head.print();

    }
}
