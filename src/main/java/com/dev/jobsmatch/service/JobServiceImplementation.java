package com.dev.jobsmatch.service;

import com.dev.jobsmatch.error.JobNotFoundException;
import com.dev.jobsmatch.model.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class JobServiceImplementation implements JobService {

    List<Job> jobs = new ArrayList<>();

    @Override
    public Job save(Job job) {
        if (job.getJobId() == null || job.getJobId().isEmpty()) {

            job.setJobId(UUID.randomUUID().toString());
        }
        jobs.add(job);
        return null;
    }

    @Override
    public List<Job> getAllJobs() {
        return jobs;
    }


    @Override
    public Job getJobById(String id) {
        return jobs.stream().filter(job -> job.getJobId().equalsIgnoreCase(id)).findFirst().orElseThrow(() -> new JobNotFoundException("This job id is not founds with Id: " + id));
    }

    @Override
    public String deleteJobById(String id) {
        Job job = jobs.stream().filter(j -> j.getJobId().equalsIgnoreCase(id)).findFirst().get();

        jobs.remove(job);
        return "Job has be been delete with the id: "+ id;
    }
}
