package org.preparation.trees;

public class UnivalOptimalSolution {

    public static void main(String[] args) {
        TreeNode root  = new TreeNode(5);
        TreeNode left  = new TreeNode(5);
        TreeNode right = new TreeNode(1);
        root.left_ptr = left;
        root.right_ptr = right;

        System.out.println(solution(root));
    }

    static int solution(TreeNode root){
        Counter c = new Counter();

        optimizedSolution(root,c);
        return c.count;
    }

    static boolean optimizedSolution(TreeNode root, Counter counter){

        if(root == null) return true;

        boolean left = optimizedSolution(root.left_ptr, counter);
        boolean right = optimizedSolution(root.right_ptr, counter);


        if(root.left_ptr!=null && root.left_ptr.val!=root.val) return false;
        if(root.right_ptr!=null && root.right_ptr.val!=root.val) return false;

        if(left && right) return true;

        counter.count++;
        return true;

    }

    static class Counter{
        int count = 0;
    }

    static class TreeNode {

        public TreeNode(int val){
            this.val = val;
        }
        int val;
        TreeNode left_ptr;
        TreeNode right_ptr;
    }

}
