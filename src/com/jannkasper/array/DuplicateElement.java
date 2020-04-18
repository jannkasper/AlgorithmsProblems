package com.jannkasper.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Find duplicate element in a limited range array
 */
public class DuplicateElement {
    public static int findDuplicate (int[] arr) {
        Set set = new HashSet();
        for (int element : arr) {
            if (set.contains(element)){
                return element;
            }
            set.add(element);
        }
        return -1;
    }

    public static int findDuplicateXOR (int[] arr) {
        int xor = 0;

        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }

        for (int i = 1; i <= arr.length-1; i++) {
            xor ^= i;
        }

        return xor;
    }

    public static int findDuplicateSum (int[] arr) {
        int sum = 0;
        int arrSum = 0;
        for (int i = 0; i< arr.length; i++) {
            arrSum += arr[i];
            if (i<arr.length-1) {
                sum += i+1;
            }
        }
        return arrSum - sum;
    }






    public static void main (String[] args)
    {
        // input keys
        int[] A = { 1, 2, 3, 4, 4 };

        System.out.println("Duplicate element is " + findDuplicate(A));
        System.out.println("Duplicate element is " + findDuplicateSum(A));
        System.out.println("Duplicate element is " + findDuplicateXOR(A));
    }
}
