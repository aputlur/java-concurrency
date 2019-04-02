package org.preparation.trees;

public class ValidBST {

    public static void main(String[] args) {
        TreeNode node = build_balanced_bst( new int[] {8,10,12,15,16,20,25});
        printPreOrder(node);
    }

    private static void printPreOrder(TreeNode node) {
        if(node == null) return;

        System.out.print(node.val + "->");
        printPreOrder(node.left_ptr);
        printPreOrder(node.right_ptr);
    }

    static class TreeNode
    {
        int val;
        TreeNode left_ptr;
        TreeNode right_ptr;

        TreeNode(int _val)
        {
            val = _val;
            left_ptr = null;
            right_ptr = null;
        }
    };

    static TreeNode build_balanced_bst(int[] a)
    {
        if(a.length == 1) return new TreeNode(a[0]);

        return buildBST(a, 0, a.length-1);

    }

    static TreeNode buildBST(int[] a, int start, int end){

        int mid = (start + end)/2;

        if(start > end) return null;

        TreeNode root = new TreeNode(a[mid]);

        root.left_ptr = buildBST(a,start,mid-1);
        root.right_ptr = buildBST(a,mid+1,end);

        return root;

    }

}
