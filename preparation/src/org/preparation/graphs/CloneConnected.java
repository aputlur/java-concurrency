package org.preparation.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CloneConnected {

    public static void main(String[] args) {
        BFS.Vertex vertex = new BFS.Vertex(1);
        clone(vertex);
    }

    static BFS.Vertex clone(BFS.Vertex vertex){

        Map<Integer,BFS.Vertex> cloneMap =  new HashMap<>();
        return cloneObject(vertex, cloneMap);

    }

    private static BFS.Vertex cloneObject(BFS.Vertex vertex, Map<Integer,BFS.Vertex> cloneMap) {

        if(cloneMap.containsKey(vertex.label))
            return cloneMap.get(vertex.label);

          BFS.Vertex clone = new BFS.Vertex(vertex.getLabel());

          //


        return clone;


     }

}
