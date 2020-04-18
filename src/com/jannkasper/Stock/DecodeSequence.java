package com.jannkasper.Stock;

import java.util.Stack;

/**
 * 6. Decode the given sequence to construct minimum number without repeated digits
 */
public class DecodeSequence {

    public static StringBuilder decode(String seq) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i <=seq.length(); i++) {
            stack.add(i + 1);

            if (i == seq.length() || seq.charAt(i) == 'I') {
                while (!stack.empty()) {
                    result.append(stack.pop());
                }
            }
            }

        return result;
    }
    public static void main(String[] args)
    {
        // input sequence
        String seq = "IDIDII";

        System.out.println("Minimum number is " + decode(seq));
    }
}
