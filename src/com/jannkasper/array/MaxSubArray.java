package com.jannkasper.array;

/**
 * 23. Print continuous subarray with maximum sum
 * Input: { -2, 1, -3, 4, -1, 2, 1, -5, 4 }
 * Output: { 4, -1, 2, 1 }, sum = 6
 */

public class MaxSubArray {
    public static void subArrayMaxSum (int[] arr) {
        // store details of maximum sum
        int maxSum = 0;
        int maxStart = 0, maxEnd = 0;

        // store current situation
        int currentSum = 0;
        int startIndex = 0;

        // traverse the given array
        // TIME COMPLEXITY O(n)
        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum+ arr[i];

            // if currentSum < 0 then start counting from next index
            if (currentSum < 0) {
                currentSum = 0;
                startIndex = i+1;
            }

            // if currentSum > maxSum then update maximum details
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxStart = startIndex;
                maxEnd = i;
            }
        }

        // print result
        System.out.println("The sum of contiguous sub-array with the " +
                "largest sum is " +	maxSum);

        System.out.print("The contiguous sub-array with the largest sum is ");
        for (int i = maxStart; i <= maxEnd; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        // input keys
        int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        subArrayMaxSum(A);

    }
}
