package org.preparation.trees;

public class CloneBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        cloneBST(root);
    }

    private static TreeNode cloneBST(TreeNode root) {

        if(root == null) return null;

        TreeNode clone = new TreeNode(root.val);
        clone.left = cloneBST(root.left);
        clone.right = cloneBST(root.right);
        return clone;
        // root = 1, 2 ,3
        // clone = 1
        // cloneBST(2)
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

}
