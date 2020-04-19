package com.jannkasper.array;

/**
 * 50. Given an unsorted array of integers, check if it contains four elements tuple (Quadtuples) having given sum.
 * Input: { 2, 7, 4, 0, 9, 5, 1, 3 }
 * Output: Quadruplet Exists
 */
public class Quadtuples {

    public  static boolean quadTuple(int[] arr, int length, int sum, int count) {

        // return true when desired sum is reached
        if ( sum == 0 && count == 4) {
            return true;
        }

        // return false when sum is not possible with current configuration
        if (count > 4 || length == 0) {
            return false;
        }

        // Recur with including/excluding current element
        // TIME COMPLEXITY O(2^n)
        return quadTuple(arr, length-1, sum - arr[length-1], count + 1) ||
                quadTuple(arr, length-1, sum, count);
    }

    public static void main(String[] args) {
        // input keys
        int[] A = { 2, 7, 4, 0, 9, 5, 1, 3 };
        int sum = 20;


        if (quadTuple(A, A.length, sum, 0)) {
            // print result
            System.out.print("Quadruplet Exists");
        } else {
            System.out.print("Quadruplet Don't Exist");
        }
    }
}
