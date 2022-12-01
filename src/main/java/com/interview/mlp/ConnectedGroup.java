package com.interview.mlp;

public class ConnectedGroup {


    public int findCircleNum( int[][] matrix  ){

        int length = matrix.length;
        UnionFind uf = new UnionFind( length );

        for( int i=0; i<length-1; i++ ){
            for( int j=i+1; j<length; j++ ){
                if( matrix[i][j] == 1 ){
                    uf.union(i, j);
                }
            }
        }

        return uf.getCount();
    }



    private static class UnionFind {

        private int[] parents;
        private int count = 0;

        public UnionFind( int size ){
            this.parents = new int[ size ];
            this.count = size;

            //Set every node to be its own parent
            for( int i=0; i<size; i++ ){
                parents[i] = i;
            }
        }


        //Combine two disjoint sets into one
        public void union( int edge1, int edge2 ){
            int parent1 = find(edge1 );
            int parent2 = find(edge2 );

            if( parent1 < parent2 ){
                parents[parent2] = parent1;
            }else{
                parents[parent1] = parent2;
            }

            count--;
        }


        //Find the parent of the given edge
        public int find( int edge ){
            //If the index == value then we found the parent
            if( edge == parents[edge] ){
                return edge;
            }

            //Recursively check the parent
            return find( parents[edge] );

        }

        public int getCount(){
            return count;
        }


    }


    public static void main(String[] args) {

        int[][] matrix= new int[][]{
                {1, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 1}
        };

        ConnectedGroup gg = new ConnectedGroup();
        int count = gg.findCircleNum( matrix );
        System.out.println(count);
    }

}
