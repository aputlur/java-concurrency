package org.preparation.trees;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPossiblePaths {

    public static void main(String[] args) {

        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(3);


       printAllPossiblePaths(node);
    }

    private static void printAllPossiblePaths(Node node) {

        if(node == null) return;
        List<Integer> allPaths = new ArrayList<>();
        printAllPathsHelper(node, allPaths);
    }

    private static void printAllPathsHelper(Node node, List<Integer> allPaths) {
        allPaths.add(node.val);

        if(node!=null && node.left==null && node.right==null)
            print(allPaths);

        if(node!=null && node.left!=null)
            printAllPathsHelper(node.left, allPaths);

        if(node!=null && node.right!=null)
            printAllPathsHelper(node.right, allPaths);

        allPaths.remove(allPaths.size()-1);
    }

    static void print(List<Integer> allPaths){

        for(int path : allPaths){
            System.out.print(path + " ");
        }
        System.out.println();
    }
    static class Node {

        int val;

        public Node(int val) {
            this.val = val;
        }

        Node left;
        Node right;
    }
}
