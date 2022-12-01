package com.interview.misc;

import java.util.*;


public class CloneGraph {

    class GraphNode {
        public int val;
        public List<GraphNode> neighbors;
        public GraphNode(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

    }

    public Map<Integer, GraphNode> map = new HashMap();

    /**
        Given a reference of a node in a connected undirected graph.
        Return a deep copy (clone) of the graph.
     */

    public GraphNode cloneGraph( GraphNode node ) {
        if( node == null ){
            return null;
        }

        if( map.containsKey(node.val) ){
            return map.get(node.val);
        }

        GraphNode cloned = new GraphNode(node.val);
        map.put(cloned.val, cloned);

        for( GraphNode neighbor: node.neighbors ){
            cloned.neighbors.add(cloneGraph(neighbor));
        }

        return cloned;

    }

}
