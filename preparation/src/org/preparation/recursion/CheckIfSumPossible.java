package org.preparation.recursion;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CheckIfSumPossible {

    public static void main(String[] args) {
        boolean result = check_if_sum_possible(new long[] {-3,-3,-3,-3,2}, -12);
        System.out.println(result);
    }

    /*
     * Complete the function below.
     */
    static boolean check_if_sum_possible(long[] arr, long target) {
        if(arr==null) return false;
        if(arr.length==1 && arr[0]==target) return true;

        long[] out = new long[arr.length];

        return checkSumPossible(arr, out,0, target,0,false);

    }
    // -3 -3 4 5 -3 -3 k = -12
    //  2 1 4 8 k = 6
    static boolean checkSumPossible(long[] arr, long[] out, int i, long target, int k,boolean result){

       Set<Long> sets =  solve(arr,out,i,target,0);
        System.out.println(sets);
        System.out.println(sets.contains(target));
        return sets.contains(target);
    }

    private static Set<Long> solve(long[] arr, long[] out, int i, long target, int k) {
        if(i==arr.length){
            long sofar = 0;
            for(int j=0; j<k;j++){
                sofar+=out[j];
            }

            return new HashSet<>(Collections.singletonList(sofar));
        }
        Set<Long> sets = new HashSet<>();
        sets.addAll(solve(arr, out, i+1, target,k));
        out[k] = arr[i];
        sets.addAll(solve(arr,out,i+1,target,k+1));

        return sets;

    }

}
