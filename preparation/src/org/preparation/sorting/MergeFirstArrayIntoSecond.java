package org.preparation.sorting;

public class MergeFirstArrayIntoSecond {

    public static void main(String[] args) {
        int[] arr1 = new int[] { 2, 3, 5 };
        int[] arr2 = new int[] { 3, 4, 6, 0, 0, 0 };
        merger_first_into_second(arr1, arr2);

        for(int k: arr2){
            System.out.print(k + ",");
        }
    }

    //arr1Pointer = 0
    //arr2Pointer = -1
    //currPointer = 0
    //5 > =0 -> 5 > 6 -> no -> else -> 2, 4, 6, 0, 0, 6
    //4 >= 0 -> 5 > 4 -> yes ->  2, 4, 6, 0, 5, 6
    //3 >= 0 -> 3 > 4 -> no ->  2, 4, 6, 4, 5, 6
    //2 >= 0 -> 3 >2  -> yes ->  2, 4, 3, 4, 5, 6
    //1 >=0 -> 1 > 2 -> no -> 2, 2, 3, 4, 5, 6
    //0>=0 -> ArrayIndexOutOfBoundException
    //Always, had a question how do I know which one has buffer. We can simply check and make recursive call.

    //

    static int[] merger_first_into_second(int[] arr1, int[] arr2) {

        if(arr1==null || arr2==null ||(arr1.length < 1 || arr2.length <1)) return null;

        if(arr1.length > arr2.length){
            merger_first_into_second(arr2,arr1);
        }
        int arr1Pointer = arr1.length - 1;
        int arr2Pointer = arr1.length - 1;
        int currPointer = arr2.length - 1;

        while (currPointer >= 0 && arr1Pointer>=0 && arr2Pointer>=0) {

            if (arr1[arr1Pointer] >= arr2[arr2Pointer]) {
                arr2[currPointer--] = arr1[arr1Pointer--];
            } else {
                arr2[currPointer--] = arr2[arr2Pointer--];
            }
        }

        if(arr1Pointer>=0)
            arr2[currPointer--] = arr1[arr1Pointer--];
        else if(arr2Pointer >=0)
            arr2[currPointer--] = arr2[arr2Pointer--];

        return arr2;
    }

}
