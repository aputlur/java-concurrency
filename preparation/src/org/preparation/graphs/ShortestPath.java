package org.preparation.graphs;

import java.util.*;

public class ShortestPath {

    List<Integer> findShortestPath(BFS.Vertex source, BFS.Vertex dest){

        Set<Integer> seen = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> path = new LinkedList<>();

        queue.add(source.label);
        seen.add(source.label);

        while(!queue.isEmpty()){

           Integer curr =  queue.pollFirst();
           path.add(curr);

           for(BFS.Vertex v : source.getNeigbhors()){
           path.add(curr);
           if(curr == dest.label) {
               //print path
               return path;
           }
           }
        }
        return Collections.emptyList();
    }

}
