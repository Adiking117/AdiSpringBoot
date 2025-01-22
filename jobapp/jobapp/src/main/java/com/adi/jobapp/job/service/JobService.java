package com.adi.jobapp.job.service;

import com.adi.jobapp.job.model.Job;

import java.util.List;

public interface JobService {
    List<Job> getALlJobs();
    Job createJob(Job job);
    Job getJobById(long id);
    Job updateJob(long id,Job updatedJob);
    boolean deleteJobById(long id);
}
