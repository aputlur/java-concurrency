package org.preparation.recursion;

public class Extension1 {

    public static void main(String[] args) {

        solve(new int[] { 1, 2, 3 }, 0);
    }

    private static void solve(int[] ints, int i) {

        if (i == ints.length - 1) {
            print(ints);
            return;
        }

        for (int j = i; j < ints.length; j++) {
            if (valueAtPositionOk(ints[j], i)) {
                swap(i, j, ints);
                solve(ints, i + 1);
                //reset to previous state
                swap(i, j, ints);
            }
        }
    }

    private static boolean valueAtPositionOk(int val, int i) {
        if (val % 2 == 1 && i % 2 == 0 || val % 2 == 0 && i % 2 == 1) {
            return true;
        }
        return false;
    }

    static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr) {

        for (int k : arr) {

            System.out.print(k + " ");
        }
        System.out.println();
    }
}
