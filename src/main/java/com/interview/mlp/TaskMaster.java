package com.interview.mlp;

import java.util.*;

public class TaskMaster {

    static class Task {
        int taskNum;
        private boolean visited;
        private List<Task> dependency = new ArrayList<>();

        public Task( int taskNum ){
            this.taskNum = taskNum;
        }

        void addDependentTask(Task dTask) {
            dependency.add(dTask);
        }

        boolean isCyclic(){
            if( visited ){
                return true;
            }
            visited = true;

            for( Task dTask : dependency ){
                if( dTask.isCyclic() ){
                    return true;
                }
            }

            visited = false;
            return false;
        }

    }


    public static int getMaxTasksThatCanBeFinished( int[] tasks, int[] dependencies ){

        Map<Integer, Task> taskMap = new HashMap<>();
        Arrays.stream(tasks).forEach( x -> taskMap.put(x, new Task(x)));
        Arrays.stream(dependencies).forEach( x -> taskMap.put(x, new Task(x)));
        System.out.println( "Count: " + taskMap.size() );

        for( int i=0; i<tasks.length; i++ ){
            Task task = taskMap.get(tasks[i]);
            Task dtask = taskMap.get(dependencies[i]);
            task.addDependentTask(dtask);
        }

        int cycleCount = 0;
        for( Task task : taskMap.values() ){
            if( task.isCyclic() ){
                System.out.println( task.taskNum + " is cyclic");
                ++cycleCount;
            }
        }

        //For every cycle we can do 1 task
        int taskCount = (taskMap.size() - (cycleCount/2));
        return taskCount;
    }


    public static void main(String[] args) {
        int[] tasks     = {7, 6, 4, 1, 2, 1};
        int[] depends   = {1, 2, 3, 4, 6, 5, };
        int count = getMaxTasksThatCanBeFinished( tasks, depends );
        System.out.println( count );
    }

}
