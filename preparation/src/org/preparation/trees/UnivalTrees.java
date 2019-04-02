package org.preparation.trees;

public class UnivalTrees {

    public static void main(String[] args) {
        TreeNode root  = new TreeNode(5);
        TreeNode left  = new TreeNode(5);
        TreeNode right = new TreeNode(5);
        root.left = left;
        root.right = right;

        int numberOfUnivalTrees = findUnivalTrees(root);
        System.out.println(numberOfUnivalTrees);
    }

    private static int findUnivalTrees(TreeNode root) {

        // return 0;
        if(root == null) {
            return 0;
        }

        int count = findUnivalTrees(root.left) + findUnivalTrees(root.right);

        if(isUnival(root)){
            count +=1;
        }
        return count;
    }

    static boolean isUnival(TreeNode root){

        if(root==null) return true;

        // instead of comparing valid values
        if(root.right!=null && root.right.val != root.val) return false;

        if(root.left!=null && root.left.val != root.val) return false;

        if(isUnival(root.left) && isUnival(root.right)) return true;

        return false;
    }

    static class TreeNode {

        public TreeNode(int val){
            this.val = val;
        }
        int val;
        TreeNode left;
        TreeNode right;
    }
}
