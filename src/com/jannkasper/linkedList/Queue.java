package com.jannkasper.linkedList;

public class Queue {
    private Node top;
    private int size;

    public Queue() {
        this.top = null;
        this.size = 0;
    }

    public void enqueue(int x) {
        size++;
        top = new Node(x, top);
        System.out.println("Inserted: " + top.data);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        Node tail = top;
        for (int i = 0; i < size-1; i++){
            tail = tail.next;
        }
        int popData = tail.data;
        tail.next = null;
        size--;
        System.out.println("Removed: " + popData);
        return popData;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        Node tail = top;
        for (int i = 0; i < size-1; i++){
            tail = tail.next;
        }
        return tail.data;
    }
    public static void main(String[] args)
    {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        System.out.printf("Front element is %d\n", q.peek());

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        if (q.isEmpty()) {
            System.out.print("Queue is empty");
        } else {
            System.out.print("Queue is not empty");
        }
    }
}
