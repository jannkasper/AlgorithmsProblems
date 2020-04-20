package com.jannkasper.linkedList;

import java.util.PriorityQueue;

/**
 * Merge K sorted linked list
 * Input: { 1 -> 2 -> 5 -> 7 -> 10 }, { 1 -> 3 -> 6 -> 7 -> 9 }, { 2 -> 4 -> 5 -> 6 -> 7 }
 * Output: 1 -> 1 -> 2 -> 2 -> 3 -> 4 -> 5 -> 5 -> 6 -> 6 -> 7 -> 7 -> 7 -> 9 -> 10
 */
public class MergeManyLists {

    public static Node mergeMinHeap (Node[] headsArray) {
        // dummy node for output linkedList
        Node mainHead = new Node(0,null);
        Node mainTail = mainHead;

        // SPACE COMPLEXITY O(1)
        PriorityQueue priorityQueue = new PriorityQueue((n1, n2) -> ((Node)n1).data - ((Node)n2).data);
        for(int i = 0; i < headsArray.length; i++) {
            priorityQueue.add(headsArray[i]);
        }

        // TIME COMPLEXITY O(n+m+k)
        while (!priorityQueue.isEmpty()) {
            // find out smallest root from group
            Node min = (Node) priorityQueue.poll();
            mainTail = mainTail.next = min;

            if(min.next != null) {
                priorityQueue.add(min.next);
            }
        }

        return mainHead.next;
    }

    public static Node merge (Node[] headsArray) {
        Node mainHead = new Node(0,null);
        Node mainTail = mainHead;
        Node subHead = headsArray[0];

        // copy first linkedList to output
        while(subHead != null){
            mainTail = mainTail.next = new Node(subHead.data, null);
            subHead = subHead.next;
        }

        // select next linkedList
        // TIME COMPLEXITY O(m)
        for (int i = 1; i<headsArray.length; i++) {
            mainTail = mainHead;
            subHead = headsArray[i];

            // insert next values to output linkedList
            // TIME COMPLEXITY O(n)
            while (subHead != null){
                if (subHead.data <= mainTail.next.data || mainTail.next == null){
                    mainTail.next = new Node(subHead.data, mainTail.next);
                    subHead = subHead.next;
                }
                // iterate thru output until
                // TIME COMPLEXITY O(k)
                while (subHead != null && mainTail.next != null && subHead.data > mainTail.next.data) {
                    mainTail = mainTail.next;
                }
            }
        }
        return mainHead.next;
    }



    public static void main(String[] args) {
        // input keys
        int[] keysA = { 1,2,5,7,10 };
        int[] keysB = { 1,3,6,7,9 };
        int[] keysC = { 2,4,5,6,7 };

        Node headA = null;
        for (int i = keysA.length - 1; i >= 0; i--) {
            headA = new Node(keysA[i], headA);
        }

        Node headB = null;
        for (int i = keysB.length - 1; i >= 0; i--) {
            headB = new Node(keysB[i], headB);
        }
        Node headC = null;
        for (int i = keysC.length - 1; i >= 0; i--) {
            headC = new Node(keysC[i], headC);
        }

        headA.print();
        headB.print();
        headC.print();
        Node[] list = {headA, headB, headC};
        Node head = mergeMinHeap(list);
//        Node head = merge(list);
        head.print();

    }
}
