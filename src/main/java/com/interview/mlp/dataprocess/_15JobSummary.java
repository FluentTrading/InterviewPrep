package com.interview.mlp.dataprocess;

import java.util.*;

public class _15JobSummary {

    //Start_JOB
    //Last_Job
    //Number_of_Jobs
    //Job_Chains_Runtime
    //Average_Runtime
    public static final void generateSummary( Map<Integer, JobNode> jobMap ){

        for( JobNode node : jobMap.values() ){

            int id = node.jobId;
            int lastJobId = -1;
            int count = 0;
            int runtime = 0;

            while( node != null && id != 0 ){
                runtime += node.runtime;
                lastJobId = node.jobId;
                ++count;

                node = node.nextJob;
            }

            if( id != 0 ) {
                System.out.println("Start_Job: " + id);
                System.out.println("Last_Job: " + lastJobId);
                System.out.println("Number_Jobs: " + count);
                System.out.println("Total_Runtime: " + runtime);
                System.out.println("Average_Runtime: " + (runtime / count));
            }
        }


    }


    public static final void processInput( List<String[]> input ){

        Map<Integer, JobNode> jobMap = new HashMap<>();

        for( String[] tokens : input ){
            int jobId = Integer.parseInt(tokens[0]);
            int runtime = Integer.parseInt(tokens[1]);
            int nextJobId = Integer.parseInt(tokens[2]);

            jobMap.put(jobId, new JobNode(jobId, runtime));
        }

        //doUnionFind( connections, jobMap );
    }

    private static void doUnionFind( List<int[]> connections, Map<Integer, JobNode> jobMap ){
        int[] parent = new int[25];
        Arrays.fill(parent, -1 );
        for( int nodeId : jobMap.keySet() ){
            parent[nodeId] = nodeId;
        }
        System.out.println("InitialParent: " + Arrays.toString(parent));

        //Do Union
        for( int[] connection : connections ){
            doUnion( connection, parent );
        }
        //System.out.println("After Union: " + Arrays.toString(parent));

        Map<Integer, Set<JobNode>> linkedMap = new HashMap<>();
        for( int i=0; i<parent.length; i++ ){
            Set<JobNode> set = linkedMap.getOrDefault(i, new HashSet<>());
            JobNode node =  jobMap.get(i);
            if( node == null ) continue;

            set.add(node);
            linkedMap.put(i, set );
            System.out.println(i + " ==> " + set );
        }


        //System.out.println( linkedMap);
    }


    private static void doUnion( int[] connection, int[] parent ){
        System.out.println("DoUnion: " + Arrays.toString(connection));
        int first = connection[0];
        int second= connection[1];
        if( second == 0 ) return;

        if( first < second ) {
            parent[second] = first;
        }else{
            parent[first] = second;
        }

        System.out.println("Parent: " + Arrays.toString(parent) + "\n");
    }


    public static void main( String[] args ){
        List<String[]> input = new ArrayList<>();
        input.add( new String[]{ "1", "60", "23"} );
        input.add( new String[]{ "2", "50", "3"} );
        input.add( new String[]{ "3", "10", "0"} );
        input.add( new String[]{ "23", "20", "4"} );
        input.add( new String[]{ "5", "50", "0"} );
        input.add( new String[]{ "4", "60", "0"} );

        processInput( input );
    }


}
