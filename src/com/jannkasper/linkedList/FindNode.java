package com.jannkasper.linkedList;

/**
 * 23. Find K'th node from the end in a linked list
 * Input: { 1, 2, 3, 4, 5, 6 }, number = 3
 * Output: 4
 */
public class FindNode {

    public static int recursiveFindNode (Node head, int k) {
        // return when reach end of linked list
        if (head == null || head == null) {
            return k-1;
        }

        // TIME COMPLEXITY O(n)
        k = recursiveFindNode(head.next, k);
        if (k == 0) {
            System.out.println(head.data);
        }
        // count position when recursive function go back
        return k-1;
    }

    public static Node findNode (Node head, int k) {
        Node current = head;

        // find pointer with k steps from root
        // TIME COMPLEXITY O(n)
        for (int i = 0; current != null && i < k; i++) {
            current = current.next;
        }

        if (current == null) return null;

        // move both pointers until reach end by second pointer
        // TIME COMPLEXITY O(n)
        while (current != null) {
            current = current.next;
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {
        // input keys
        int[] keys = { 1,2,3,4,5,6 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        int k = 3;
        recursiveFindNode(head,k);

        // print result
        System.out.println(findNode(head,k).data);

    }
}
