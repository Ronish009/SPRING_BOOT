package com.example.controller;

import com.example.entity.Applicant;
import com.example.entity.Job;
import com.example.repository.JobRepository;
import com.example.service.JobService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public ResponseEntity<Job> addJob(@RequestBody Job job) {
        Job job1 = jobService.createJob(job);
        return ResponseEntity.ok(job1);
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJob() {
        List<Job> job = jobService.getAllJob();
        return ResponseEntity.ok(job);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable("id") Long id){
        return ResponseEntity.ok(jobService.getJobById(id));
    }

    @PostMapping("/add-job-to-applicant")
    public ResponseEntity<Applicant> addJobToApplicant(@RequestParam Long applicantId, @RequestParam Long jobId){
        return ResponseEntity.ok(jobService.addJobtoApplicant(applicantId,jobId));
    }

}
