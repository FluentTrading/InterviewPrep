package com.interview.arrays;

import java.util.*;

public class TaskScheduler {

    /**
     * Given an array of tasks representing the tasks a CPU needs to do.
     * Tasks could be done in any order.
     * Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
     *
     * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array),
     * that is that there must be at least n units of time between any two same tasks.
     *
     * Return the least number of units of times that the CPU will take to finish all the given tasks.
     *
     * Tasks    = ["A","A","A","B","B","B"], n = 2
     * Output   = [8] A -> B -> idle -> A -> B -> idle -> A -> B
     */

    //Do the most frequent task first wo we can disperse it out with other tasks
    //Need a freq map and a Max heap to store the frequency in descending order.
    public int scheduleTask( char[] tasks, int n ) {

        Map<Character, Integer> taskFreq = new HashMap<>();
        for( char task : tasks ){
            taskFreq.put(task, taskFreq.getOrDefault(task, 0) + 1);
        }

        Queue<Integer> maxHeap = new PriorityQueue<>( Comparator.reverseOrder() );
        for( int freq : taskFreq.values() ){
            maxHeap.offer(freq);
        }

        int currTime = 0;
        //[Count of Task, TimeToWait before it can be processed]
        Deque<Integer[]> coolDownQueue = new ArrayDeque<>();

        //while either of the places has tasks
        while( !maxHeap.isEmpty() || !coolDownQueue.isEmpty() ){
            ++currTime;

            if( !maxHeap.isEmpty() ){
                int taskCountLeftToProcess = maxHeap.poll() - 1;
                if( taskCountLeftToProcess != 0 ){
                    //Need to cool down, this task will be available after n mins/secs
                    coolDownQueue.add(new Integer[]{taskCountLeftToProcess, currTime+n});
                }
            }

            //Check cooldown map to see if there is a task that's now available to be scheduled
            if( !coolDownQueue.isEmpty() && coolDownQueue.peek()[1] == currTime ){
                maxHeap.offer( coolDownQueue.poll()[0] );
            }

        }

        return currTime;

    }


    public static void main( String[] args ){
       char[] taskArray = new char[]{'A','A','A','B','B','B'};
       int coolDownPeriod = 2;

       int minTimeTaken = new TaskScheduler().scheduleTask(taskArray, coolDownPeriod);
       System.out.println("Min time taken to schedule " + Arrays.toString(taskArray) + " tasks is " + minTimeTaken );
    }

}
