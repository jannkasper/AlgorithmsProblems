package com.jannkasper.linkedList;

/**
 * Find K'th node from the end in a linked list
 */
public class FindNode {

    public static int recursiveFindNode (Node head, int k) {
        if (head == null || head == null) {
            return k-1;
        }
        k = recursiveFindNode(head.next, k);
        if (k == 0) {
            System.out.println(head.data);
        }

        return k-1;
    }

    public static Node findNode (Node head, int k) {
        Node current = head;

        for (int i = 0; current != null && i < k; i++) {
            current = current.next;
        }

        if (current == null) return null;

        while (current != null) {
            current = current.next;
            head = head.next;
        }
        return head;
    }



    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1,2,3,4,5,6 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        int k = 3;
        recursiveFindNode(head,k);
        System.out.println(findNode(head,k).data);

    }
}
