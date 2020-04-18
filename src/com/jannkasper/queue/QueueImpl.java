package com.jannkasper.queue;

import java.util.Stack;

/**
 * 4. Implement a Queue using Stack Data Structure
 */
public class QueueImpl<T> {
    private Stack<T> stack1, stack2;

    public QueueImpl() {
        this.stack1 = new java.util.Stack<>();
        this.stack2 = new java.util.Stack<>();
    }

    public void enqueue(T x) {
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        stack1.add(x);
        System.out.println("Inserted: " + stack1.peek());
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            System.exit(0);
        }
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        T popData = stack2.pop();
        System.out.println("Removed: " + popData);
        return popData;
    }

    public boolean isEmpty() {
        return stack1.empty() && stack2.empty();
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            System.exit(0);
        }
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        T peekData = stack2.peek();
        return peekData;

    }
    public static void main(String[] args)
    {
        QueueImpl<Integer> q = new QueueImpl<>();
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
