package org.preparation.sorting;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * 6,10,3,-4,1,-6,9
 * -6,-4,1,3,6,9,10
 * currentElement = -6 AND sumNeeded = 6;
 * --------------------------------------
 * left = -4, right = 10
 * left + right = 6
 * sumNeeded == left+right then found  (-6,-4,10)
 * -----------------------------------------
 * currentElement = -6
 * left = 1 and right 10
 * 1 + 10 == 6
 */
public class ThreeSum {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(findZeroSum(new int[] { 6, 10, 3, -4, 1, -6, 9 })));
    }

    static String[] findZeroSum(int[] arr) {
        // Sort Input Array and O(N^2) times to find the matching elements

        // Sort
        Arrays.sort(arr);
        TreeSet<String> result = new TreeSet<>();
        int n = arr.length - 1;

        //Iterate Over Array
        for (int index = 0; index < n; index++) {

            int currElement = arr[index];
            int neededSum = -currElement;

            int left = index + 1;
            int right = n;

            while (left < right) {

                int leftVal = arr[left];
                int rightVal = arr[right];
                int sum = leftVal + rightVal;

                if (sum == neededSum) {
                    String s = currElement + "," + leftVal + "," + rightVal;
                    if (!result.contains(s)) {
                        result.add(s);
                    }
                    left++;
                }

                else if (sum > neededSum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }

}
