package com.jannkasper.queue;

import java.util.ArrayDeque;

/**
 * 12. Generate Binary Numbers Between 1 to N using Queue
 * Input: 10
 * Output: 1 10 11 100 101 110 111 1000 1001 1010
 */
public class BinaryNumbers {

    public static void binaryNumbers(int number){
        // Collect next binary numbers
        // SPACE COMPLEXITY O(n)
        java.util.Queue<String> queue = new ArrayDeque<>();
        queue.add("1");

        int current = 1;
        // TIME COMPLEXITY O(n)
        while (current++ <= number) {
            // append 0 and 1 to the front element of the queue and enqueue both strings
            queue.add(queue.peek() + "0");
            queue.add(queue.peek() + "1");

            // pop the front element and print it
            System.out.println(queue.poll() + " ");
        }
    }

    public static void main(String[] args)
    {
        int n = 10;
        binaryNumbers(n);

    }
}
