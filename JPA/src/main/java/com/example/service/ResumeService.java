package com.example.service;

import com.example.entity.Applicant;
import com.example.entity.Resume;
import com.example.exception.ResumeNotFoundException;
import com.example.repository.ApplicantJpaRespository;
import com.example.repository.ResumeJpaRespository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeService {

    @Autowired
    ResumeJpaRespository resumeJpaRespository;
    @Autowired
    ApplicantJpaRespository  applicantJpaRespository;

    public Resume addResume(Long applicantId, Resume resume) {
        Applicant applicant = applicantJpaRespository.findById(applicantId)
                .orElseThrow(() ->
                        new ResumeNotFoundException("Applicant not found with Id: " + applicantId));
            resume.setApplicant(applicant);
            return resumeJpaRespository.save(resume);
    }
}
