package com.interview.graph;

public class CourseSchedule {

    /**
     * There are a total of numCourses courses you have to take.
     * You are given an array prerequisites where the pair [0, 1], indicates that to take course 0 you have to first take course 1.
     * Return true if you can finish all courses. Otherwise, return false.
     */

    //NOTE: Equivalent to finding a cycle in a directed graph!
    public boolean canFinish( Integer[][] prerequisites ){

        DirectedGraph<Integer> graph = new DirectedGraph<>(true );
        graph.build( prerequisites );

        boolean canFinish = !graph.hasCycle();
        System.out.println( "Graph can canFinish =" + canFinish );

        return canFinish;
    }


    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        //Must take 0 before taking 1

        boolean canFinish = cs.canFinish(new Integer[][]{
                {5, 5}
        });

        System.out.println( "Can Finish? " + canFinish);
    }

}
