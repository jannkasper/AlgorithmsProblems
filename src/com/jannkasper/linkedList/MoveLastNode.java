package com.jannkasper.linkedList;

/**
 * Move last node to front in a given Linked list
 */
public class MoveLastNode {

    public static Node rearrange(Node head) {
        if ( head == null || head.next == null) {
            return head;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.next == null) {
                current.next.next = head;
                head = current.next;
                current.next = null;
                break;
            }
            current = current.next;
        }

        return head;
    }

    public static Node recurse(Node head, Node current) {
        if (current.next.next == null){
            current.next.next = head;
            head = current.next;
            current.next = null;
            return head;
        }
        return recurse(head,current.next);
    }

    public static Node rearrangeRecure(Node head) {
        if ( head == null || head.next == null) {
            return head;
        }
        return  recurse(head, head);
    }

    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1,9,8,7,6,6,5,4,3,2 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

//        head = rearrange(head);
        head = rearrangeRecure(head);
        head.print();
    }
}
