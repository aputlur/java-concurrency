package org.preparation.recursion;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountPaths {

    public static void main(String[] args) {
        int[][] arr = new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        int count = countPaths(arr, 0, 0);
        System.out.println("Number of Paths : "+ count);

        Deque<String> deque = new ArrayDeque<>();
        printPaths(arr, 0, 0, deque);

    }

    /**
     * base-case 1 : If i == M and j == N return 0
     * base-case 2 : if arr[0][0] == 1 return 0;
     * base-case 3 : if i==m-1 and j ==n-1 return 1
     *
     * @param arr
     * @param i
     * @param j
     * @return
     */
    static int countPaths(int[][] arr, int i, int j) {

        //base-conditions
        int M = arr.length;
        int N = arr[0].length;

        if (i == M || j == N)
            return 0;

        if (M == 0)
            return 0;

        if (M == 1)
            return 1;

        if (i == M - 1 && j == N - 1)
            return 1;

        return countPaths(arr, i + 1, j) + countPaths(arr, i, j + 1);
    }

    /**
     * Recurrance RelationShip -> List out all the possible cases.
     *
     * When GRID is of size 0 or null, nothing to print
     * When i==M or j==N, go over right or down
     * When i==M-1 and j==N-1, reached the destination print the path
     * When there is path, pop out from the stack
     *
     *
     */
    static void printPaths(int[][] arr, int i, int j, Deque<String> deque){

        //base-conditions
        int M = arr.length;
        int N = arr[0].length;

        if (i == M || j == N)
            return;

        if (M == 0)
            return;

        if (M == 1)
            deque.pop();

        if(i==M-1 && j==N-1) {
           deque.push("(" + i + ","+ j + ")");
            System.out.println(deque.pop());

            return;
        }

        deque.push("(" + i + ","+ j + ")");


        printPaths(arr,i+1,j,deque);
        printPaths(arr,i,j+1,deque);
        System.out.println(deque.pop());
        return;



    }

}
