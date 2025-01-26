package com.adi.jobms.job.service;


import com.adi.jobms.job.dao.JobDAO;
import com.adi.jobms.job.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    // private List<Job> jobs;

    private JobDAO jobDAO;

    @Autowired
    public  JobServiceImpl(JobDAO jobDAO){
        // this.jobs = new ArrayList<>();
        this.jobDAO = jobDAO;
    }

    @Override
    public List<Job> getALlJobs() {
        // return jobs;
        return jobDAO.findAll();
    }

    @Override
    public Job createJob(Job job) {
//        jobs.add(job);
        jobDAO.save(job);
        return job;
    }

    @Override
    public Job getJobById(long id) {
//        for(Job j : jobs){
//            if(j.getId() == id){
//                return j;
//            }
//        }
//        return null;
        return jobDAO.findById(id).orElse(null);
    }

    @Override
    public Job updateJob(long id,Job updatedJob) {
//        for(Job j : jobs) {
//            if (j.getId() == id) {
//                j.setTitle(updatedJob.getTitle());
//                j.setDescription(updatedJob.getDescription());
//                j.setSalary(updatedJob.getSalary());
//                j.setLocation(updatedJob.getLocation());
//                return j;
//            }
//        }
        Optional<Job> jobToUpdate = jobDAO.findById(id);
        if(jobToUpdate.isPresent()){
            Job j = jobToUpdate.get();
            j.setTitle(updatedJob.getTitle());
            j.setDescription(updatedJob.getDescription());
            j.setSalary(updatedJob.getSalary());
            j.setLocation(updatedJob.getLocation());
            jobDAO.save(j);
            return j;
        }
        return null;
    }

    @Override
    public boolean deleteJobById(long id) {
//        for(Job j : jobs) {
//            if (j.getId() == id) {
//                jobs.remove(j);
//                return true;
//            }
//        }
//        return false;
        try {
            jobDAO.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }


}
