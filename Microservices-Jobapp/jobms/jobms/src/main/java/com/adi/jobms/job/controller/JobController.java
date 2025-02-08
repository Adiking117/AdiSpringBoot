package com.adi.jobms.job.controller;


import com.adi.jobms.job.Response.JobResponse;
import com.adi.jobms.job.model.Job;
import com.adi.jobms.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs(){
        // return new ResponseEntity<>(jobService.getALlJobs(), HttpStatus.OK);
        return ResponseEntity.ok(jobService.getALlJobs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobResponse> getJobById(@PathVariable long id){
        return ResponseEntity.ok(new JobResponse("Job fetched successfully",jobService.getJobById(id)));
    }

    @PostMapping("/add")
    public ResponseEntity<JobResponse> createJob(@RequestBody Job jobToAdd){
        if(jobService.createJob(jobToAdd) != null){
            return ResponseEntity.ok(new JobResponse("Job has been added",jobToAdd));
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<JobResponse> updateJob(@PathVariable long id,@RequestBody Job jobToUpdate){
        if(jobService.updateJob(id,jobToUpdate) != null){
            return ResponseEntity.ok(new JobResponse("Job has been updated",jobToUpdate));
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteJob(@PathVariable long id){
        if(jobService.deleteJobById(id)){
            return ResponseEntity.ok("Job has been deleted");
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
