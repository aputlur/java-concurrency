package org.preparation.graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFS {


    void dfs(Vertex vertex){

        Set<Integer> visited = new HashSet<>();

        for(int i=0;i<vertex.getNeigbhors().size();i++){

            if(!visited.contains(vertex.getLabel())){
                explore(visited, vertex);
            }
        }

    }

    private void explore(Set<Integer> visited, Vertex vertex) {
    }

    class Vertex {

        int          label;
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
    }

}
