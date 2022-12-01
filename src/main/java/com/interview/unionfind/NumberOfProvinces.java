package com.interview.unionfind;


public class NumberOfProvinces {

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
        public void union( int edge1, int edge2 ){
            int parent1 = find(edge1 );
            int parent2 = find(edge2 );
            if( parent1 != parent2 ){
                parents[parent1] = parent2;
                --count;
            }
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

    public int findCircleNum( int[][] matrix  ){

        int n = matrix.length;
        UF uf = new UF(n);

        for( int i = 0; i < n - 1; i++ ){
            for( int j = i + 1; j < n; j++ ){
                if( matrix[i][j] == 1 ){
                    uf.union(i, j);
                }
            }
        }

        return uf.count;
    }



}
