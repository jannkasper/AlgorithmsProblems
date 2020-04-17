package com.jannkasper.linkedList;

public class Stack {
   private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(int x) {
       Node next = new Node(x, top);
       top = next;
       System.out.println("Inserted: " + top.data);
   }

   public boolean isEmpty() {
       return top == null;
   }

   public int peek() {
        if (!isEmpty()) {
            return top.data;
        }
       System.out.println("Stack is empty");
        return -1;
   }

    public int pop() {
        if (!isEmpty()) {
            int popData = top. data;
            top = top.next;
            System.out.println("Removed: " + popData);
            return popData;
        }
        System.out.println("Stack is empty");
        return -1;
    }
    public static void main(String[] args)
    {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element is " +  stack.peek());

        stack.pop();
        stack.pop();
        stack.pop();

        if (stack.isEmpty()) {
            System.out.print("Stack is empty");
        } else {
            System.out.print("Stack is not empty");
        }
    }
}
