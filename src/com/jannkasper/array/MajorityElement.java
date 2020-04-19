package com.jannkasper.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 17. Find majority element in array (Boyer-Moore majority vote algorithm)
 * Input: { 2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2 }
 * Output: 2
 */

public class MajorityElement {

    public static int majorityBoyerMoore (int[] arr) {
        int key = -1;
        int counter = 0;

        // TIME COMPLEXITY O(n)
        for (int i = 0; i<arr.length; i++) {
            // if counter became = 0, pick up current value
            if (counter == 0) {
                key = arr[i];
                counter = 1;
            // increase counter when current value == current key
            } else if (key == arr[i]) {
                counter++;
            } else {
                counter--;
            }
        }
        return key;
    }

    public static int majorityElement (int[] arr) {
        // count each value <value, amount>
        // SPACE COMPLEXITY O(n)
        Map<Integer, Integer> map = new HashMap<>();

        // calculate each element's frequency
        // TIME COMPLEXITY O(n)
        for (int element : arr) {
            map.putIfAbsent(element, 0);
            map.put(element, map.get(element) + 1);
        }
        int key = -1;

        // return the element if its count is more than n/2
        // TIME COMPLEXITY O(n)
        for (Map.Entry entry : map.entrySet()) {
            if ((int)entry.getValue() > arr.length/2) {
                return (int)entry.getKey();
            }
        }

        // no majority element is present
        return key;
    }

    public static void main(String[] args)
    {
        // input keys
        int arr[] = { 2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2 };

        int res = majorityBoyerMoore(arr);

        // print result
        if (res != -1) {
            System.out.println("Majority element is " + res);
        } else {
            System.out.println("Majority element does not exist");
        }
    }
}
