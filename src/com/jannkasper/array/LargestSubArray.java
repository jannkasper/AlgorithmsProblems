package com.jannkasper.array;

import java.util.*;

/**
 * 16. Find largest sub-array formed by consecutive integers
 *     The array should contain all distinct values
 * Input: { 2, 0, 2, 1, 4, 3, 1, 0 }
 * Output: { 0, 2, 1, 4, 3 }
 */
public class LargestSubArray {
    public static int[] findMaxSubArray (int[] arr) {
        // start searching from largest array
        int length = arr.length;
        int pointer = 0;

        // number of elements in subArray
        // TIME COMPLEXITY O(n)
        while (pointer + length <= arr.length && length > 1) {
            // Collect visited values per each iteration
            // SPACE COMPLEXITY O(n)
            Set<Integer> set = new HashSet<>();

            // iterate each subArray with n elements
            // TIME COMPLEXITY O(n)
            for (int j = pointer; j < pointer + length; j++) {
                // break subArray when duplicated values
                if (set.contains(arr[j])) {
                    break;
                }

                // return subArray with distinct values
                if (j == pointer + length - 1) {
                    return Arrays.copyOfRange(arr, pointer, j + 1);
                }

                // add current element to set
                set.add(arr[j]);
            }

            // if you visited last subArray with current length, check shorter ones
            if (pointer + length == arr.length) {
                pointer = 0;
                length--;
            } else {
                pointer++;
            }
        }
        return null;
    }

    public static void main(String[] args)
    {
        // input keys
        int[] A = { 2, 0, 2, 1, 4, 3, 1, 0 };

        int[] result = findMaxSubArray(A);
        System.out.println(Arrays.toString(result));

    }
}
