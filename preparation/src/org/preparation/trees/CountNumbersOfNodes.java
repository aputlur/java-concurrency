package org.preparation.trees;

public class CountNumbersOfNodes {

    static int count = 0;
    public static void main(String[] args) {

        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(3);
        node.right.right = new Node(5);
        node.right.right.right = new Node(5);
        node.right.right.right.right = new Node(5);
        node.right.right.right.right.right = new Node(5);


       int count =  countTrees(node);
        System.out.println(count);
    }

    private static int countTrees(Node node) {
        if(node == null) return 0;

        return countTrees(node.left) + countTrees(node.right) + 1;


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
