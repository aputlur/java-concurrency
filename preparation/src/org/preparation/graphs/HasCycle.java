package org.preparation.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HasCycle {

    static void solution() {
        HashMap<Integer, Integer> status = new HashMap<>();
        List<BFS.Vertex> list = new ArrayList<>();

        hasCycle(list, status);
    }

    private static void hasCycle(List<BFS.Vertex> list, HashMap<Integer,Integer> status) {

        for(BFS.Vertex v : list){
            status.put(v.label,0);
            if(!status.containsKey(v.label)){

            }
        }
    }

}
