package com.interview.graph;

import java.util.*;

public class DirectedGraph<T> extends Graph<T>{

    enum NodeState{
        VISITED,
        VISITING;
    }

    public DirectedGraph( boolean isDirected ){
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
        Map<T, NodeState> visited = new HashMap<>();
        for( T vertex : getAdjacencyMap().keySet() ){
            if( hasCycle(vertex, visited) ){
                return true;
            }
        }

        return false;
    }


    /**
     *  Consider graph  A -> B <- C  if we just use a visited set.
     *
     *  The loop above will start with A and visit B. Visited set has (A, B)
     *  Loop then goes to C, then visit B.
     *  But B was already visited, this will signal a cycle (where there isn't one).
     *  Essentially we need to remember the "path" to B (AB != CB) and not just whether B was visited.
     *  That's why we use NodeState
     */
     private boolean hasCycle( T vertex, Map<T, NodeState> visited ){

        visited.put( vertex, NodeState.VISITING );

        List<T> neighbors = getAdjacencyMap().get(vertex);
        for( T neighbor : neighbors ){
            NodeState state = visited.get(neighbor);
            if( state == null ){
                if( hasCycle(neighbor, visited) ){
                    return true;
                }

            }else{
                if( NodeState.VISITING == state ){
                    return true;
                }
            }

        }

        visited.put( vertex, NodeState.VISITED );
        return false;

    }


}
