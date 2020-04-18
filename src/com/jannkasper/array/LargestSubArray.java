package com.jannkasper.array;

import java.util.*;

/**
 * 16 Find largest sub-array formed by consecutive integers
 */

public class LargestSubArray {
    public static int[] findMaxSubArray (int[] arr) {
        int length = arr.length;
        int pointer = 0;

        while (pointer + length <= arr.length && length>1) {
            Set<Integer> set = new HashSet<>();
            for (int j = pointer; j < pointer + length; j++) {
                if (set.contains(arr[j])) {
                    break;
                }
                if (j == pointer + length - 1) {
                    return Arrays.copyOfRange(arr,pointer,j+1);
                }
                set.add(arr[j]);
            }
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
