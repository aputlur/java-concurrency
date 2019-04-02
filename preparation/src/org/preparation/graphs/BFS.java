package org.preparation.graphs;

import java.util.*;

public class BFS {

    void bfs(Vertex vertex) {

        Set<Integer> seen = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(vertex.label);
        seen.add(vertex.label);

        while(!queue.isEmpty()){

           Integer curr =  queue.pollFirst();
           //print
            //loop through
        }

    }

    static class Vertex {

        int              label;
        List<Vertex> neigbhors;

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        public List<Vertex> getNeigbhors() {
            return neigbhors;
        }

        public void setNeigbhors(List<Vertex> neigbhors) {
            this.neigbhors = neigbhors;
        }

        public Vertex(int label){
            this.label = label;
        }
    }

}
