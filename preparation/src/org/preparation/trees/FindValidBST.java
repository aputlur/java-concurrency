package org.preparation.trees;

public class FindValidBST {

    public static void main(String[] args) {

        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(3);

        isBST(node);
    }

    static boolean isBST(Node node){

        if(node == null) return false;
        return isBSTHelper(node, node.val, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBSTHelper(Node root, int rootVal, int min, int max){

        // in-case of left tree it should be less than rootVal

        if(min > rootVal || max < rootVal) return false;

        if(root.left!=null)
        isBSTHelper(root.left, rootVal, root.left.val, max);

        if(root.right!=null)
            isBSTHelper(root.right, rootVal, min, root.right.val);

        return true;
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
