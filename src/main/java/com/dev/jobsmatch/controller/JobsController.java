package com.dev.jobsmatch.controller;

import com.dev.jobsmatch.model.Job;
import com.dev.jobsmatch.service.JobService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {

    private static final Logger LOG = LogManager.getLogger(JobsController.class);


    @Autowired
    private JobService jobService;



    /* Replace this with new method signature below
        public ResponseEntity<Job> createJob(@RequestBody Job job) {
     */
//    @PostMapping
//    public ResponseEntity<String> createJob(@RequestBody String job) {
//
//        LOG.info("Received request to create new job {}", job);
//        return new ResponseEntity<String>(HttpStatus.CREATED);
//    }

    @GetMapping("/jobInformation")
    public Job jobs(){
        Job job = new Job();
        job.setJobId("12324");
        job.setTitle("IT Lead");
        job.setDescription("Team lead");
        job.setHiringCompany("Johnson/Johnson");
        job.setLocation("Boston");
        job.setAdditionalInformation("Leadership Qualities");
        job.setContactInformation("Phone number and telephone number");

        return job;
    }
    @PostMapping
    public Job save(@RequestBody Job job){
        return jobService.save(job);
    }

    @GetMapping("/allJobs")
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable String id){

        return jobService.getJobById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteJobById(@PathVariable String id){

        return jobService.deleteJobById(id);
    }
}
