package org.preparation.recursion;

import java.util.Arrays;

public class SubSetOfGivenSet {

    public static void main(String[] args) {

        printAllSubsets(new char[] {'a','b','c'});
        /**
         * {}
         * a
         * b
         * c
         * ab
         * bc
         * ac
         * abc
         * 2^n = 8
         *
         */
    }

    /**
     *
     * Recurrance relationship: All possible cases
     *
     *    abc
     *    / \
     *   {}  {abc}
     *        / \
     *       a  {abc}
     *      / \
     *     {}  a
     *
     * @param chars
     */
    private static void printAllSubsets(char[] chars) {

        char[] output = new char[chars.length];
        printSubSets(chars,0,output,0);
    }

    private static void printSubSets(char[] chars, int i, char[] output, int k) {

        if(i==chars.length) {
            print(output,k);
            return;
        }

        printSubSets(chars,i+1,output,k);
        output[k] = chars[i];
        printSubSets(chars,i+1,output,k+1);
    }

    private static void print(char[] output,int k) {
        System.out.print("{");
        for(int i=0;i<k;i++)
            System.out.print(output[i] + " ");
        System.out.print("}");
    }

}
