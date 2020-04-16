package com.jannkasper.linkedList;

import java.util.PriorityQueue;

/**
 * Merge K sorted linked list
 */
public class MergeManyLists {

    public static Node mergeMinHeap (Node[] headsArray) {
        Node mainHead = new Node(0,null);
        Node mainTail = mainHead;

        PriorityQueue priorityQueue = new PriorityQueue((n1, n2) -> ((Node)n1).data - ((Node)n2).data);
        for(int i = 0; i < headsArray.length; i++) {
            priorityQueue.add(headsArray[i]);
        }

        while (!priorityQueue.isEmpty()) {
            Node min = (Node) priorityQueue.poll();
            mainTail = mainTail.next = min;

            if(min.next != null) {
                priorityQueue.add(min.next);
            }
        }

        return mainHead.next;
    }

    public static Node mergeUgly (Node[] headsArray) {
        Node mainHead = new Node(0,null);
        Node mainTail = mainHead;
        Node subHead = headsArray[0];
        while(subHead != null){
            mainTail = mainTail.next = new Node(subHead.data, null);
            subHead = subHead.next;
        }
        for (int i = 1; i<headsArray.length; i++) {
            mainTail = mainHead;
            subHead = headsArray[i];

            while (subHead != null){
                if (subHead.data <= mainTail.next.data || mainTail.next == null){
                    mainTail.next = new Node(subHead.data, mainTail.next);
                    subHead = subHead.next;
                }

                while (subHead != null && mainTail.next != null && subHead.data > mainTail.next.data) {
                    mainTail = mainTail.next;
                }
            }
        }
        return mainHead.next;
    }



    public static void main(String[] args)
    {
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
//        Node head = mergeUgly(list);
        head.print();

    }
}
