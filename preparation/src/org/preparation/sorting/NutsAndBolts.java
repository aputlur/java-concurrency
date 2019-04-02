package org.preparation.sorting;

public class NutsAndBolts {

    public static void main(String[] args) {

       String[] output =  solve(new int[] {4,32,5,7}, new int[] {32,7,5,4});
        for(String s : output){
            System.out.println(s);
        }
    }

    /*
     * Complete the solve function below.
     */
    static String[] solve(int[] nuts, int[] bolts) {

        if(nuts==null || bolts==null || nuts.length < 1 || bolts.length<1) return null;

        mergeSort(nuts);
        mergeSort(bolts);
        int[] mergedArray = new int[(nuts.length+bolts.length)];
        merge(mergedArray, nuts, bolts);

        String[] output = new String[nuts.length];
        for(int k=0; k<nuts.length;k++){
            output[k] = nuts[k] + " "+ bolts[k];

        }
        return output;
    }


    static void mergeSort(int[] arr){

        if(arr.length ==1) return;
        int mid = arr.length/2 + (arr.length%2);
        int[] firstHalf = new int[mid];
        int[] secondHalf = new int[arr.length-mid];

        split(arr,firstHalf,secondHalf);
        mergeSort(firstHalf);
        mergeSort(secondHalf);

        merge(arr, firstHalf, secondHalf);
    }

    static void merge(int[] arr, int[] firstHalf, int[] secondHalf){
        int left = 0;
        int right = 0;
        int curr = 0;

        while(left < firstHalf.length && right < secondHalf.length){

            if(firstHalf[left] >= secondHalf[right]){
                arr[curr++] = secondHalf[right++];
            }
            else {
                arr[curr++] = firstHalf[left++];
            }
        }
        while(left < firstHalf.length){
            arr[curr++] = firstHalf[left++];
        }
        while(right < secondHalf.length){
            arr[curr++] = secondHalf[right++];
        }

    }
    static void split(int[] arr, int[] firstHalf, int[] secondHalf){

       int index = 0;

       for(int k : arr){

           if(index < firstHalf.length) {
               firstHalf[index] = k;
           }
           else {
               secondHalf[index - firstHalf.length] = k;
           }
           index++;
       }
    }



}
