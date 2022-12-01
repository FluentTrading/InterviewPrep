package com.interview.arrays;

import java.util.*;

public class TaskScheduler {

    //Do the most frequent task first wo we can disperse it out with other tasks
    //Need a freq map and a Max heap to store the freq
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
