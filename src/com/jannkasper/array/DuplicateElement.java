package com.jannkasper.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 5. Find duplicate element in a limited range array
 * Input: { 1, 2, 3, 4, 4 }
 * Output: 4
 */
public class DuplicateElement {
    public static int findDuplicate (int[] arr) {
        // collect visited values
        // SPACE COMPLEXITY O(n)
        Set set = new HashSet();

        // TIME COMPLEXITY O(n)
        for (int element : arr) {
            // return duplicated value
            if (set.contains(element)){
                return element;
            }
            set.add(element);
        }

        // no duplicate element
        return -1;
    }

    public static int findDuplicateXOR (int[] arr) {
        int xor = 0;

        // calculate XOR of all array elements
        // TIME COMPLEXITY O(n)
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }

        // calculate XOR of numbers from 1 to n-1
        // TIME COMPLEXITY O(n)
        for (int i = 1; i <= arr.length-1; i++) {
            xor ^= i;
        }

        return xor;
    }

    public static int findDuplicateSum (int[] arr) {
        int sum = 0;
        int arrSum = 0;

        // TIME COMPLEXITY O(n)
        for (int i = 0; i< arr.length; i++) {
            // calculate array sum
            arrSum += arr[i];

            // calculate sum of numbers from 1 to n-1
            if (i<arr.length-1) {
                sum += i+1;
            }
        }
        // return extra value
        return arrSum - sum;
    }

    public static void main (String[] args)
    {
        // input keys
        int[] A = { 1, 2, 3, 4, 4 };

        // print results
        System.out.println("Duplicate element is " + findDuplicate(A));
        System.out.println("Duplicate element is " + findDuplicateSum(A));
        System.out.println("Duplicate element is " + findDuplicateXOR(A));
    }
}
