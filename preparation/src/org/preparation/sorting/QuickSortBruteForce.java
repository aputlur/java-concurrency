package org.preparation.sorting;


public class QuickSortBruteForce {

    static int[] outArray = new int[4];

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 1, 0 };
//        quickSort(arr);
        solutionWithNoExtraSpace(arr,0,arr.length-1);
        for (int k : arr) {
            System.out.print(k + ",");
        }


        quickSort2(arr,0,arr.length-1);
        for (int k : arr) {
            System.out.print(k + ",");
        }
    }

    private static int[] quickSort1(int[] data){

            if( data.length < 2 ){
                return data;
            }

            int pivotIndex = data.length / 2;
            int pivotValue = data[ pivotIndex ];

            int leftCount = 0;

            // Count how many are less than the pivot

            for( int i = 0; i < data.length; ++i ){
                if( data[ i ] < pivotValue ) ++leftCount;
            }

            // Allocate the arrays and create the subsets

            int[] left = new int[ leftCount ];
            int[] right = new int[ data.length - leftCount - 1 ];

            int l = 0;
            int r = 0;

            for( int i = 0; i < data.length; ++i ){
                if( i == pivotIndex ) continue;

                int val = data[ i ];

                if( val < pivotValue ){
                    left[ l++ ] = val;
                } else {
                    right[ r++ ] = val;
                }
            }

            // Sort the subsets

            left = quickSort1( left );
            right = quickSort1( right );

            // Combine the sorted arrays and the pivot back into the original array

            System.arraycopy( left, 0, data, 0, left.length );
            data[ left.length ] = pivotValue;
            System.arraycopy( right, 0, data, left.length + 1, right.length );

            return data;
        }


        //not working
    private static int[] quickSort2(int[] arr, int start, int end){

        if(arr.length < 2) return arr;

        int pivot = start;
        int pivotVal = arr[pivot];

        int leftCount = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= pivotVal){
                leftCount++;
            }
        }
        if(leftCount == 1) return arr;

        int[] outArray = new int[arr.length];
        int l = 0;
        int r = leftCount;
        outArray[leftCount-1] = pivotVal;

        for(int k=0; k<arr.length;k++){

            if(pivot == k) continue;

            if(arr[k] < pivotVal) outArray[l++] = arr[k];

            else outArray[r++] = arr[k];

        }
       return quickSort2(outArray,0, outArray.length-1);

    }


    private static int[] quickSort(int[] arr) {

        if (arr.length < 2)
            return arr;

        int pivot = 0;
        int pivotVal = arr[pivot];

        int le_count = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] < pivotVal)
                ++le_count;
        }

        int[] left = new int[le_count];
        int[] right = new int[arr.length - le_count-1];

        int l = 0;
        int r = 0;
        for (int k = 0; k < arr.length; k++) {

            if (arr[k] == pivotVal)
                continue;

            if (arr[k] < pivotVal) {
                left[l++] = arr[k];
            } else {
                right[r++] = arr[k];
            }
        }
        left =  quickSort(left);
        right = quickSort(right);

        System.arraycopy(left, 0, arr, 0, left.length);
        arr[left.length] = pivotVal;
        System.arraycopy(right, 0, arr, left.length + 1, right.length);

        return arr;
    }

    private static int partition(int[] arr, int start, int end, int pivot) {

        int le_count = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] <= pivot)
                le_count++;
        }

        int le = 0;
        int gt = le_count;

        outArray[le_count - 1] = pivot;

        for (int i = 0; i <= end; i++) {

            if (arr[i] == pivot)
                continue;

            if (arr[i] <= pivot) {
                outArray[le++] = arr[i];
            } else {
                outArray[gt++] = arr[i];
            }
        }
        System.out.println("le_count -> " + le_count);
        for (int k : outArray) {
            System.out.print(k + ",");
        }
        return le_count - 1;
    }

    private static int solutionWithNoExtraSpace(int[] arr, int start, int end){

        int pivot = arr[start];
        int l = start;
        int h = end;

        while(l < h){

            while(arr[l] <=pivot)
                l++;
            while(arr[h] > pivot)
                h--;

            if(l < h){
                swapElements(arr, l, h);
            }
        }
        swapElements(arr, start,h);
        return h;

    }

    private static void swapElements(int[] arr, int l, int h) {
        int temp = arr[l];
        arr[l] = arr[h];
        arr[h] = temp;
    }

    private static int choosePivot(int[] arr, int start, int end) {
        return start;
    }

}
