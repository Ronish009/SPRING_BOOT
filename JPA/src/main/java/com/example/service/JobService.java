package com.example.service;

import com.example.entity.Applicant;
import com.example.entity.Job;
import com.example.exception.ApplicantNotFoundException;
import com.example.exception.JobNotFoundException;
import com.example.repository.ApplicantJpaRespository;
import com.example.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private ApplicantJpaRespository applicantJpaRespository;
    @Autowired
    private JobRepository  jobRepository;

    public Job createJob(Job job){
        return jobRepository.save(job);
    }

    public List<Job> getAllJob(){
        return jobRepository.findAll();
    }

    public Job getJobById(Long Id){
        return jobRepository.findById(Id).orElseThrow(()->new JobNotFoundException("Ronish Job not found"));
    }

    public Applicant addJobtoApplicant(Long applicantId, Long jobId){
        Objects.requireNonNull(applicantId);
        Objects.requireNonNull(jobId);
        Applicant applicant1 = applicantJpaRespository.findById(applicantId).orElseThrow(() -> new ApplicantNotFoundException("Applicant not found"));
        Job job1 = jobRepository.findById(jobId).orElseThrow(() -> new JobNotFoundException("Job not found "));
        applicant1.getJobs().add(job1);
        applicantJpaRespository.save(applicant1);
        return applicant1;
    }
}
