package org.preparation.trees;

public class SumOfAllNumbers {

    static Integer counter = 0;
    public static void main(String[] args) {

        Node node = new Node(2);
        //left tree
        node.left = new Node(2);
        node.right = new Node(10);
        node.left.left = new Node(1);
        System.out.println(sumOfAllNumbers(node));
    }

    private static int sumOfAllNumbers(Node root) {
        if(root==null) return 0;
        counter+= root.val;
        sumOfAllNumbers(root.left);
        sumOfAllNumbers(root.right);
//        int left1 = sumOfAllNumbers(root.left);
        return counter;

    }

    static class Node {
        int val;
        public Node(int val){
            this.val = val;
        }
        Node left;
        Node right;
    }
}
