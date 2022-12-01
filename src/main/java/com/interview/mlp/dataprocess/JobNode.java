package com.interview.mlp.dataprocess;


public class JobNode{

    int jobId;
    int runtime;
    JobNode nextJob;


    public JobNode( int jobId, int runtime  ){
        this( jobId, runtime, null );
    }

    public JobNode( int jobId, int runtime, JobNode nextJob ){
        this.jobId = jobId;
        this.runtime = runtime;
        this.nextJob = nextJob;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JobNode [");
        sb.append("jobId=").append(jobId);
        sb.append(", runtime=").append(runtime);
        sb.append(", nextJob=").append(nextJob);
        sb.append(']');
        return sb.toString();
    }
}