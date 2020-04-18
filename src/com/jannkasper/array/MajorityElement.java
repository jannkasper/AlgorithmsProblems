package com.jannkasper.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 17. Find majority element in array (Boyer-Moore majority vote algorithm)
 */

public class MajorityElement {

    public static int majorityBoyerMoore (int[] arr) {
        int key = -1;
        int value = 0;

        for (int i = 0; i<arr.length; i++) {
            if (value == 0) {
                key = arr[i];
                value = 1;
            } else if (key == arr[i]) {
                value++;
            } else {
                value--;
            }
        }
        return key;
    }

    public static int majorityElement (int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int element : arr) {
            map.putIfAbsent(element, 0);
            map.put(element, map.get(element) + 1);
        }
        int key = -1;
        int value = -1;
        for (Map.Entry entry : map.entrySet()) {
            if ((int)entry.getValue() > value) {
                key = (int) entry.getKey();
                value = (int) entry.getValue();
            }
        }

        return key;
    }




    public static void main(String[] args)
    {
        // input keys
        int arr[] = { 1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2 };

        int res = majorityBoyerMoore(arr);
        if (res != -1) {
            System.out.println("Majority element is " + res);
        } else {
            System.out.println("Majority element does not exist");
        }


    }
}
