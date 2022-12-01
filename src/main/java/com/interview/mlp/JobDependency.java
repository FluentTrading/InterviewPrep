package com.interview.mlp;

import java.util.*;


public class JobDependency {

    public int[] findOrder(int numCourses, int[][] prerequisites ){

        // Topological sort
        // Edge case
        if( numCourses <= 0 ) return new int[0];

        //1. Init Map
        Map<Integer, Integer> inDegree      = new HashMap<>();
        Map<Integer, List<Integer>> topoMap = new HashMap<>();
        for( int i = 0; i < numCourses; i++ ){
            inDegree.put(i, 0);
            topoMap.put(i, new ArrayList<>());
        }


        //2. Build Map
        for( int[] pair : prerequisites ){
            int curCourse = pair[0];
            int preCourse = pair[1];

            topoMap.get(preCourse).add(curCourse);                  // put the child into it's parent's list
            inDegree.put(curCourse, inDegree.get(curCourse) + 1);   // increase child inDegree by 1
        }


        //3. find course with 0 indegree, minus one to its children's indegree, until all indegree is 0
        int base = 0;
        int[] res = new int[numCourses];

        while( !inDegree.isEmpty() ){

            boolean flag = false;                   // use to check whether there is cycle
            for( int key : inDegree.keySet() ){     // find nodes with 0 indegree
                if( inDegree.get(key) == 0 ){
                    res[base ++] = key;
                    List<Integer> children = topoMap.get(key);  // get the node's children, and minus their inDegree
                    for( int child : children) {
                        inDegree.put(child, inDegree.get(child) - 1);
                    }

                    inDegree.remove(key);      // remove the current node with 0 degree and start over
                    flag = true;
                    break;
                }

            }

            if(!flag)  // there is a circle --> All Indegree are not 0
                return new int[0];
        }

        return res;

    }

}
