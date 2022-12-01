package com.interview.arrays;

import java.util.*;

public class CourseSchedule {

    static class Course {

        private boolean visited;
        private List<Course> pre = new ArrayList<>();

        void addPre(Course preCourse) {
            pre.add(preCourse);
        }

        boolean isCyclic() {
            if( visited ) {
                return true;
            }
            visited = true;

            for(Course preCourse: pre ) {
                if( preCourse.isCyclic() ) {
                    return true;
                }
            }

            visited = false;
            return false;
        }

    }

    /**
     * There are a total of numCourses courses you have to take.
     * You are given an array prerequisites where the pair [0, 1], indicates that to take course 0 you have to first take course 1.
     * Return true if you can finish all courses. Otherwise, return false.
     */

    //NOTE: Need a find a cycle, if there is a circular dependency, we cant finish all the course.
    public boolean canFinish( int numCourses, int[][] prerequisites ){

        List<Course> courselist = new ArrayList<>();
        for( int i=0; i<numCourses; i++ ){
            courselist.add(new Course());
        }

        for( int[] preq : prerequisites ){
            Course c1 = courselist.get(preq[0]);
            Course c2 = courselist.get(preq[1]);
            c1.addPre(c2);
        }

        for( Course course : courselist ){
            if( course.isCyclic() ) {
                return false;
            }
        }

        return true;
    }

}
