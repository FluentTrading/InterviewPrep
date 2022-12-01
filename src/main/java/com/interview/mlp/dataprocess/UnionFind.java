package com.interview.mlp.dataprocess;

import java.util.*;

public class UnionFind {

    private Map<Integer, Integer> parent;

    public UnionFind( ){
        this.parent = new HashMap<>();
    }


    public static  int countComponents( int[][] edges ){
        int[] ids = new int[ 5000 ];
        for( int i=0; i<ids.length; i++ ){
            ids[i] = i;
        }

        for( int[] edge : edges ){
            union( edge[0], edge[1], ids );
        }

        System.out.println("After Union: " + Arrays.toString(ids));

        Set<Integer> set = new HashSet<>();
        for (int i=0; i<ids.length; i++ ){
            int parentId = find(ids[i], ids);
            set.add( parentId );
        }

        return set.size();
    }


    private static void union( int edge1, int edge2, int[] ids ){
        int parent1 = find(edge1, ids );
        int parent2 = find(edge2, ids );

        ids[parent1] = parent2;
    }

    private static int find( int edge, int[] ids ){
        //Path compression
        if( ids[edge] != edge ){
            ids[edge]  = find( ids[edge], ids );
        }

        return ids[edge];
    }


    public static void main( String[] args ){
        int[][] edges = new int[][]{
                {1, 23},
                {3, 5},
                {23, 4},
                {4, 0},
                {5, 0}
        };

        System.out.println( countComponents( edges ));
    }

}
