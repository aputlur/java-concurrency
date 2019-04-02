package org.preparation.trees;

public class DepthFirstTraversal {

    public static void main(String[] args) {
       Node node = createTree();
        System.out.println();
       depthFirstInOrderTraversal(node);
        System.out.println();

        depthFirstPreOrderTraversal(node);
        System.out.println();

       depthFirstPostOrderTraversal(node);
    }

    private static void depthFirstPreOrderTraversal(Node node) {

        if(node!=null){

            System.out.print(node.val + "->");
            depthFirstPreOrderTraversal(node.left);
            depthFirstPreOrderTraversal(node.right);
        }

    }

    private static void depthFirstPostOrderTraversal(Node node) {
        if(node!=null){

            depthFirstPostOrderTraversal(node.left);
            depthFirstPostOrderTraversal(node.right);
            System.out.print(node.val + "->");
        }

    }

    private static void depthFirstInOrderTraversal(Node node) {

        if(node!=null){

            depthFirstInOrderTraversal(node.left);
            System.out.print(node.val + "->");
            depthFirstInOrderTraversal(node.right);
        }

    }

    private static Node createTree() {

        Node node = new Node(1);
        //left tree
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(5);

        //right tree
        node.right = new Node(3);
        node.right.right = new Node(7);
        node.right.left = new Node(6);

        return node;

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
