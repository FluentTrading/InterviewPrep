package com.interview.graph;

import java.util.HashSet;
import java.util.*;

public class UndirectedGraph<T> extends Graph<T>{

    public UndirectedGraph( boolean isDirected ){
        super( isDirected );
    }

    /**
     * NOTE: Since the graph can be disconnected, we need to scan from every vertex!
     *
     * A -> [C] (disconnected)
     * D -> [E]
     * E -> [F, G]
     */
    @Override
    public boolean hasCycle( ){
        Set<T> visited = new HashSet<>();
        for( T vertex : getAdjacencyMap().keySet() ){
            if( hasCycle(vertex, visited) ){
                return true;
            }
        }

        return false;
    }


    /**
     *  Same logic as directed graph cycle,
     *  But in an undirected graph, A <-> B <-> C  we just use a visited set.
     */
     private boolean hasCycle( T vertex, Set<T> visited ){
        visited.add( vertex );

        List<T> neighbors = getAdjacencyMap().get(vertex);
        for( T neighbor : neighbors ){
            if( vertex.equals(neighbor)) continue;

            if( visited.contains(neighbor) ){
                return true;
            }else{
                if( hasCycle(neighbor, visited) ){
                    return true;
                }
            }
        }

        return false;

    }


    public static void main(String[] args) {
        Graph<Integer> graph = new UndirectedGraph<>( false );
        graph.build( new Integer[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {5, 2}
        });

        boolean result = graph.hasCycle();
        System.out.println("Is Cycle present: " + result);
    }

}
