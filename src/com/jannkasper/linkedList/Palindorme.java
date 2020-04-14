package com.jannkasper.linkedList;

/**
 * Check if Linked List is Palindrome or not
 */
public class Palindorme {
    static class NodeWrapper {
        public Node node;

        public NodeWrapper(Node node) {
            this.node = node;
        }
    }

    public static boolean palindromeRecurseWithWrapper(Node head){
        return palindromeRecurseWithWrapper(new NodeWrapper(head), head);
    }

    public static boolean palindromeRecurseWithWrapper(NodeWrapper left, Node right) {
        if (right == null) {
            return true;
        }

        boolean result = palindromeRecurseWithWrapper(left, right.next) && left.node.data == right.data;

        left.node = left.node.next;

        return result;
    }

    public static boolean palindromeRecurse(Node head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) return true;
        if (head.next.next == null && head.data == head.next.data) return true;
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        if (head.data != current.next.data) {
            return false;
        }
        current.next = null;
        return  palindromeRecurse(head.next);
    }

    public static void main(String[] args)
    {
        // input keys
//        int[] keys = { 1,3,5,3,1 };
        int[] keys = { 1,3,5,5,3,1 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        head.print();
        System.out.println(palindromeRecurseWithWrapper(head));

    }
}
