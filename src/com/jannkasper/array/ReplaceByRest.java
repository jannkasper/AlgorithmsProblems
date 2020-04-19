package com.jannkasper.array;

import java.util.Arrays;

/**
 * 19. Replace each element of an array with product (multiplication) of every other element without using division operator
 * Input: { 5, 3, 4, 2, 6, 8 }
 * Output: {1152, 1920, 1440, 2880, 960, 720}
 */
public class ReplaceByRest {
    public static int findProduct(int[] arr, int left, int current) {
        // no more elements on right side
        if (current == arr.length) {
            return 1;
        }

        // calculate product of the right side
        // TIME COMPLEXITY O(n)
        int right = findProduct(arr, left*arr[current], current+1);

        // back-up current element
        int tempCurrentValue = arr[current];

        // replace current element with product of left and right subArray
        arr[current] = left * right;

        // return product of right subArray
        return tempCurrentValue * right;
    }

    public static void main(String[] args) {
        // input keys
        int[] A = { 5, 3, 4, 2, 6, 8 };

        findProduct(A, 1,0);

        // print result
        System.out.println(Arrays.toString(A));

    }
}
