package com.jannkasper.array;

/**
 * 50. Given an unsorted array of integers, check if it contains four elements tuple (Quadtuples) having given sum.
 */
public class Quadtuples {

    public  static boolean quadTuple(int[] arr, int length, int sum, int count) {

        if ( sum == 0 && count == 4) {
            return true;
        }

        if (count > 4 || length == 0) {
            return false;
        }

        return quadTuple(arr, length-1, sum - arr[length-1], count + 1) ||
                quadTuple(arr, length-1, sum, count);
    }



    public static void main(String[] args)
    {
        int[] A = { 2, 7, 4, 0, 9, 5, 1, 3 };
        int sum = 20;

            if (quadTuple(A, A.length, sum, 0)) {
            System.out.print("Quadruplet Exists");
        } else {
            System.out.print("Quadruplet Don't Exist");
        }
    }
}
