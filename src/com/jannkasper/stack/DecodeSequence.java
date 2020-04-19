package com.jannkasper.stack;

import java.util.Stack;

/**
 * 6. Decode the given sequence to construct minimum number without repeated digits
 * Input: IDIDII
 * Output: 1325467
 */
public class DecodeSequence {

    public static StringBuilder decode(String seq) {
        StringBuilder result = new StringBuilder();

        // stack integers during decreasing and poll all collected when increasing appears again or at the end
        // SPACE COMPLEXITY O(n)
        Stack<Integer> stack = new Stack<>();

        // run n+1 times where n is length of input sequence
        // TIME COMPLEXITY O(n)
        for (int i = 0; i <=seq.length(); i++) {
            stack.add(i + 1);

            // if all characters of the input sequence are processed or
            // current character is 'I' (increasing)
            if (i == seq.length() || seq.charAt(i) == 'I') {
                while (!stack.empty()) {
                    result.append(stack.pop());
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // input sequence
        String seq = "IDIDII";

        // print result
        System.out.println("Minimum number is " + decode(seq));
    }
}
