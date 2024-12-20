package com.dev.jobsmatch.service;

import com.dev.jobsmatch.model.Job;

import java.util.List;

public interface JobService {



    Job save(Job job);

    List<Job> getAllJobs();

    Job getJobById(String id);

    String deleteJobById(String id);
}
