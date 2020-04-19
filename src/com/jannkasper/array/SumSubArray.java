package com.jannkasper.array;

import java.util.*;

/**
 * 29. Find subarray having given sum in given array of integers
 * Input: { 2, 6, 0, 9, 7, 3, 1, 4, 1, 10 }, sum = 15
 * Output: {6, 0, 9}
 */
public class SumSubArray {
    public static int[] findSubarray (int[] arr, int sum) {
        // create a map that save each step <currentSum, currentIndex>
        // SPACE COMPLEXITY O(n)
        Map<Integer, Integer> map = new HashMap();

        // calculate sum of elements
        int currentSum = 0;

        // cover case when sum start from index 0
        map.put(0, -1);

        // traverse the array
        // TIME COMPLEXITY O(n)
        for(int i = 0; i<arr.length; i ++) {
            currentSum = currentSum + arr[i];

            // if (currentSum - sum) is seen before, we found the subArray
            if (map.containsKey(currentSum-sum)) {
                return Arrays.copyOfRange(arr, map.get(currentSum-sum) +1, i+1);
            }

            // insert current sum with index
            map.put(currentSum, i);
        }

        return  null;
    }

    public static void main(String[] args) {
        // input keys
        int[] A = { 2, 6, 0, 9, 7, 3, 1, 4, 1, 10 };
        int sum = 15;

        int[] result  = findSubarray(A, sum);

        if (result != null) {
            // print result
            System.out.println(Arrays.toString(result));
        }

    }
}
