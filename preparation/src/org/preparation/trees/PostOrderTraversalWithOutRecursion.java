package org.preparation.trees;

import java.util.Stack;

public class PostOrderTraversalWithOutRecursion {

    public static void main(String[] args) {

//        Node node = new Node(-1);
//        node.left = new Node(1);
//        node.right = new Node(3);
//        node.right.right = new Node(4);

        postorderTraversal(null);
    }

    static void postTraversal(Node root){

        Node curr = root;
        Node prev = null;
        Stack<Node> stack = new Stack<>();
        stack.push(curr);
        curr = curr.left;

        while(!stack.isEmpty()) {

            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            else {
                Node top = stack.peek();
                if (top.right != null && top.right != prev) {
                    curr = top.right;
                } else {
                    Node popped = stack.pop();
                    prev = popped;
                    System.out.println(popped.val);
                }
            }
        }
    }

    static class Node {

        int val;

        public Node(int val) {
            this.val = val;
        }

        Node left;
        Node right;
    }
    static void postorderTraversal(Node root){
        if(root == null) return;

        Stack<Node> stack = new Stack<>();
        Node curr = root;
        stack.push(curr);
        curr = curr.left;
        Node prev = null;
        StringBuffer sb = new StringBuffer();

        while(!stack.isEmpty()){

            // traverse left-tree
            if(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            else {
                //pick the top node.
                Node top =  stack.peek();
                if(top.right!=null && top.right!=prev){
                    curr = top.right;
                }
                else{
                    prev = stack.pop();
                    sb.append(prev.val + " ");
                }
            }
        }
        if(sb.toString().trim().length() == 0) {
            System.out.println((String) null);
        }
        else {System.out.println(sb.toString().trim());}

    }
}
