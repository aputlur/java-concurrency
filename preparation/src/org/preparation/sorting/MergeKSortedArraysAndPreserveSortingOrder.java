package org.preparation.sorting;

import java.util.Collections;
import java.util.PriorityQueue;

public class MergeKSortedArraysAndPreserveSortingOrder {

    public static void main(String[] args) {

       int arr[][] = {{1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}} ;
       int[] result =  mergeArrays(arr);
       for(int k : result){
           System.out.print(k + ",");
       }
        System.out.println();
       //preserve sorting order
        int arr1[][] = {{7, 5, 1, 1}, {8, 6, 4, 2}, {11, 10, 9, 0}} ;
        int[] result1 =  mergeArrays(arr1);
        for(int k : result1){
            System.out.print(k + ",");
        }

    }

    static class QueueNode implements Comparable<QueueNode> {
        int id;
        int idx;
        int val;

        public QueueNode(int id, int idx, int val){
            this.id = id;
            this.idx = idx;
            this.val = val;
        }

        public int compareTo(QueueNode obj){
            return Integer.compare(this.val, obj.val);
        }
    }
    static PriorityQueue<QueueNode> getPriorityQueue(int[][] arr){

        if(arr[0].length > 0){
            boolean isReverseOrder =  arr[0][0] > arr[0][arr[0].length-1] ? true : false;

            if(isReverseOrder)
                return new PriorityQueue<>(Collections.reverseOrder());
            else
                return new PriorityQueue<>();
        }
        return null;
    }
    //
    static int[] mergeArrays(int[][] arr) {
        PriorityQueue<QueueNode> pq = getPriorityQueue(arr);

        int size = 0;
        for(int i=0; i<arr.length;i++){
            size+=arr[i].length;
            QueueNode qn = new QueueNode(i,0,arr[i][0]);
            pq.add(qn);
        }

        int[] result = new int[size];
        int index = 0;
        while(!pq.isEmpty()){

            QueueNode node = pq.poll();
            int val = node.val;
            int idx = node.idx;
            int id = node.id;
            result[index++] = val;
            int newIndex = idx+1;
            if(newIndex < arr[id].length){
                QueueNode qn = new QueueNode(id,newIndex,arr[id][newIndex]);
                pq.add(qn);
            }
        }

        return result;
    }

}
