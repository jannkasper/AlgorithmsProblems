package com.jannkasper.array;

import java.util.Arrays;

/**
 * 20. Find longest Bitonic Subarray in an array
 * Input: { 3, 5, 8, 4, 5, 9, 10, 8, 5, 3, 4 }
 * Output: { 4, 5, 9, 10, 8, 5, 3 }, length = 7
 */
public class BitonicSubarray {
    public static int[] findBitonicSubarray (int[] arr) {
        // store the length of the longest increasing sub-array
        // SPACE COMPLEXITY O(n)
        int[] inArray = new int[arr.length];
        inArray[0] = 1;

        // TIME COMPLEXITY O(n)
        for (int i =1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                inArray[i] = inArray[i-1] + 1;
            } else {
                inArray[i] = 1;
            }
        }
        // store the length of the longest decreasing sub-array
        // SPACE COMPLEXITY O(n)
        int[] deArray = new int[arr.length];
        deArray[arr.length-1] = 1;

        // TIME COMPLEXITY O(n)
        for (int i = arr.length -2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                deArray[i] = deArray[i+1] + 1;
            } else {
                deArray[i] = 1;
            }
        }

        int topLength = 1;
        int begin = 0, end = 0;
        // find index with biggest sum of increasing + decreasing elements
        // TIME COMPLEXITY O(n)
        for (int i = 0; i < arr.length; i++) {
            if (topLength < inArray[i] + deArray[i] -1) {
                topLength = inArray[i] + deArray[i] -1;
                begin = i - inArray[i] + 1;
                end = i + deArray[i] -1;
            }
        }

        return Arrays.copyOfRange(arr, begin, end+1);
    }

    public static int[] findBitonicSubarrayN (int[] arr) {
    int maxLength = 0;
    int endIndex = 0;
    int i  = 1;

    // TIME COMPLEXITY O(n)
    while ( i < arr.length) {
        int currentLength = 1;

        // calculate the length of the decreasing sub-array
        while (i < arr.length && arr[i] > arr[i-1]){
            currentLength++;
            i++;
        }

        // calculate the length of the decreasing sub-array
        while (i < arr.length && arr[i] < arr[i-1]){
            currentLength++;
            i++;
        }

        // update when currentLength > maxLength
        if (currentLength > maxLength) {
            maxLength = currentLength;
            endIndex = i;
        }
    }

        return Arrays.copyOfRange(arr, (endIndex-maxLength), endIndex);
    }

    public static void main(String[] args) {
        // input keys
        int[] A = { 3, 5, 8, 4, 5, 9, 10, 8, 5, 3, 4 };

//        int[] result = findBitonicSubarray(A);
        int[] result = findBitonicSubarrayN(A);

        // print result
        System.out.println("The length of longest bitonic subarray is " + result.length);
        System.out.println("The longest bitonic subarray is " + Arrays.toString(result));

    }
}
