package com.interview.unionfind;


public class GraphValidTree {

    private static class UF {
        private int[] parents;
        private int count;

        public UF( int n ){
            this.count = n;
            this.parents = new int[ n ];

            //Set every node to be its own parent
            for( int i=0; i<n; i++ ){
                parents[i] = i;
            }
        }

        //Combine two disjoint sets into one
        public boolean union( int edge1, int edge2 ){
            int parent1 = find(edge1 );
            int parent2 = find(edge2 );

            if( parent1 == parent2 ){
                return false; //cycle detected
            }

            parents[parent1] = parent2;
            --count;
            return true;
        }


        //Find the parent of the given edge
        public int find( int edge ){
            //If the index == value then we found the parent
            if( edge == parents[edge] ){
                return edge;
            }

            return (parents[edge] = find(parents[edge])); // Path compression
        }

    }

    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for( int[] edge: edges ){
            if( !uf.union(edge[0], edge[1]) ){
                return false;
            }
        }

        //There can only be 1 connected component for it to be a valid tree
        return ( uf.count == 1 );
    }


}
