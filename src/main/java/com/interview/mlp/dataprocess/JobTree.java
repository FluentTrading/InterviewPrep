package com.interview.mlp.dataprocess;

public class JobTree {

    int jobId;
    int runtime;
    JobTree left;
    JobTree right;


    public JobTree(int jobId ){
        this(jobId, -1, null, null);
    }

    public JobTree(int jobId, int runtime  ){
        this(jobId, runtime, null, null );
    }

    public JobTree(int jobId, int runtime, JobTree left, JobTree right ){
        this.jobId = jobId;
        this.runtime = runtime;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JobTree [");
        sb.append("jobId=").append(jobId);
        sb.append(", runtime=").append(runtime);
        sb.append(", left=").append(left);
        sb.append(", right=").append(right);
        sb.append(']');
        return sb.toString();
    }
}