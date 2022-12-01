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


    public boolean canFinish( int numCourses, int[][] prerequisites ){

        List<Course> clist = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            clist.add(new Course());
        }

        for(int[] couple: prerequisites ) {
            Course c1 = clist.get(couple[0]);
            Course c2 = clist.get(couple[1]);
            c1.addPre(c2);
        }

        for(int i=0; i<numCourses; i++) {
            if( clist.get(i).isCyclic() ) {
                return false;
            }
        }

        return true;
    }

}
