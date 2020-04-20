package com.jannkasper.linkedList;

/**
 * 28. Check if Linked List is Palindrome or not
 * Input: 1 -> 3 -> 5 -> 5 -> 3 -> 1
 * Output: true
 */
public class Palindrome {
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
        // Recursive to compare front node with the last
        boolean result = palindromeRecurseWithWrapper(left, right.next) && left.node.data == right.data;

        // move left to next node
        left.node = left.node.next;

        return result;
    }

    public static void main(String[] args) {
        // input keys
        int[] keys = { 1,3,5,5,3,1 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        head.print();

        // print result
        System.out.println(palindromeRecurseWithWrapper(head));

    }
}
