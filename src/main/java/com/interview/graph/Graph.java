package com.interview.graph;

import java.util.*;

public abstract class Graph<T>{

    private boolean isDirected;
    private Map<T, List<T>> adjacencyMap;

    public Graph( boolean isDirected ){
        this.isDirected     = isDirected;
        this.adjacencyMap   = new LinkedHashMap<>();
    }


    protected Map<T, List<T>> getAdjacencyMap( ){
        return adjacencyMap;
    }

    /**
     * Given the matrix, builds an adjacency list
     *
     * {0, 1, 2}    0 => [1, 2]
     * {1, 4}       1 => [4]
     * {2, 3}       2 => [3]
     *
     */
    public void build( T[][] dataMatrix ){
        for( T[] data : dataMatrix ){
            T from  = data[0];

            for( int i=1; i<data.length; i++ ){
                 addEdge(from, data[i]);
            }
        }
    }

    public void addEdge( T from, T to ){
        adjacencyMap.putIfAbsent(from, new ArrayList<>());
        adjacencyMap.get( from ).add(to);

        if( !isDirected ){
            adjacencyMap.putIfAbsent(to, new ArrayList<>());
            adjacencyMap.get( to ).add( from );
        }
    }

    public abstract boolean hasCycle( );


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        System.out.println( "Keys: " + adjacencyMap.keySet() );

        for( T key : adjacencyMap.keySet() ){
            builder.append( key ).append("\t");

            for(T neighbor : adjacencyMap.get(key) ){
                builder.append( neighbor ).append(" ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }

}
