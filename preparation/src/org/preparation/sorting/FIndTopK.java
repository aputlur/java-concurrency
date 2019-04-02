package org.preparation.sorting;

import java.util.*;

public class FIndTopK {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(topK(new int[]{4,
                8,
                9,
                6,
                6,
                2,
                10,
                2,
                8,
                1,
                2},9)));
    }

    static int[] topK(int[] arr, int k) {

        TreeSet<Integer> tree = new TreeSet<>();

        for(int i=0; i<arr.length;i++){
            tree.add(arr[i]);
            if(tree.size() > k){
                tree.pollFirst();
            }
        }
        int[] result = new int[tree.size()];
        int currIndex = 0;
        for(int val : tree){
            result[currIndex++] = val;
        }
        return result;
    }

}
