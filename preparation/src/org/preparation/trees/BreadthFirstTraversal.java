package org.preparation.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTraversal {

    public static void main(String[] args) {

        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(3);

        bfs(node);
    }

    private static void bfs(Node node) {

        if (node == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.println(curr.val + " -> ");

            if (curr.left != null)
                queue.add(curr.left);

            if (curr.right != null)
                queue.add(curr.right);
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

}
