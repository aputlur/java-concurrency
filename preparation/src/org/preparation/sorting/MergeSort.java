package org.preparation.sorting;


public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] {2,3,1,0};
        mergeSort(arr);
        for(int k : arr){
            System.out.print(k + ",");
        }
    }

    private static void mergeSort(int[] arr) {

        if(arr.length==1) return;
        int mid = arr.length/2 + (arr.length%2);

         int[] firstHalf = new int[mid];
         int[] secondHalf = new int[arr.length-mid];

         split1(arr, firstHalf,secondHalf);

         mergeSort(firstHalf);
        mergeSort(secondHalf);
        merge(arr, firstHalf,secondHalf);
    }

    private static void split1(int[] arr, int[] firstHalf, int[] secondHalf) {
        int index = 0;

        for(int k : arr){

            if(index < firstHalf.length){
                firstHalf[index] = k;
            }
            else {
                secondHalf[index - firstHalf.length] = k;
            }
            index++;
        }
    }

    private static void merge(int[] arr, int[] L, int[] R) {

        int leftIndex = 0;
        int rightIndex = 0;
        int currIndex = 0;

        while(leftIndex<L.length && rightIndex<R.length){

            if(L[leftIndex] <= R[rightIndex]){
                arr[currIndex] = L[leftIndex];
                leftIndex++;
            }
            else {
                arr[currIndex] = R[rightIndex];
                rightIndex++;
            }
            currIndex++;

        }
       while(leftIndex < L.length){
            arr[currIndex] = L[leftIndex];
            leftIndex++;
            currIndex++;
       }
       while(rightIndex < R.length){
            arr[currIndex] = R[rightIndex];
            rightIndex++;
            currIndex++;
       }
    }

}
