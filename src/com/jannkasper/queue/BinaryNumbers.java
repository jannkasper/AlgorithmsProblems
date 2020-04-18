package com.jannkasper.queue;

import java.util.ArrayDeque;

/**
 * 12. Generate Binary Numbers Between 1 to N using Queue
 */
public class BinaryNumbers {

    public static void binaryNumbers(int number){
        java.util.Queue<String> queue = new ArrayDeque<>();
        queue.add("1");

        int current = 1;
        while (current++ <= number) {
            queue.add(queue.peek() + "0");
            queue.add(queue.peek() + "1");

            System.out.println(queue.poll() + " ");
        }
    }





    public static void main(String[] args)
    {
        int n = 16;
        binaryNumbers(n);

    }
}
