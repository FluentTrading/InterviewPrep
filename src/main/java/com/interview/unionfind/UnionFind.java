package com.interview.unionfind;

public class UnionFind {

    private int[] parents;
    private int countDisjoint;

    public UnionFind( int n ){
        this.parents = new int[n];
        this.countDisjoint =n;
        //Initially, treat all nodes as disjoint and set them to be its own parent.
        for( int i=0; i<n; i++ ){
            parents[i] = i;
        }
    }

    public int getDisjointCount(){
        return countDisjoint;
    }


    public boolean union( int node1, int node2 ){

        int parent1 = find(node1);
        int parent2 = find(node2);

        //Parent of both nodes are the same, therefore it means they were already connected
        if( parent1 == parent2 ){
            return false;
        }

        parents[parent1] = parent2;
        --countDisjoint;

        return true;
    }


    public int find( int node ){
        //node matches the value at parents[index], so it is the root node.
        if( node == parents[node] ){
            return node;
        }

        //Otherwise, recursively take the parent of the given node and check it
        int recursiveParent = find( parents[node] );

        //Once found, set it to be the parent
        //Path compression (this step is not necessary but used to flatten the tree)
        parents[node] = recursiveParent;

        return recursiveParent;
    }


}
