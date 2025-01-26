package com.adi.jobms.job.Response;

import com.adi.jobms.job.model.Job;

public class JobResponse {
    private String message;
    private Job job;

    public JobResponse(String message, Job job) {
        this.message = message;
        this.job = job;
    }


    // Getters and setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "JobResponse{" +
                "message='" + message + '\'' +
                ", job=" + job +
                '}';
    }
}
