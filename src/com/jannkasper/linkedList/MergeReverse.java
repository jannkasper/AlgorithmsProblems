package com.jannkasper.linkedList;

public class MergeReverse {

    public static Node mergeReverse (Node headA, Node headB) {
        Node head = null;
        Node temp = null;
        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                temp = headA;
                headA = headA.next;
                temp.next = head;
                head = temp;
            } else {
                temp = headB;
                headB = headB.next;
                temp.next = head;
                head = temp;
            }
        }
        while (headA != null) {
            temp = headA;
            headA = headA.next;
            temp.next = head;
            head = temp;
        }

        while (headB != null) {
            temp = headB;
            headB = headB.next;
            temp.next = head;
            head = temp;
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
        Node head = mergeReverse(headA, headB);
        head.print();

    }
}
