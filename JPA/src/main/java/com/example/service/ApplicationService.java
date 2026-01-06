package com.example.service;

import com.example.entity.Applicant;
import com.example.entity.Application;
import com.example.exception.ApplicantNotFoundException;
import com.example.exception.ApplicationNotFoundException;
import com.example.repository.ApplicantJpaRespository;
import com.example.repository.ApplicationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    ApplicationJpaRepository applicationJpaRepository;

    @Autowired
    ApplicantJpaRespository  applicantJpaRespository;


    public Application saveAppication(Long applicantId, Application application) {
     Applicant application1 = applicantJpaRespository
             .findById(applicantId).orElseThrow(()->new ApplicationNotFoundException("No Applicant is associated with Application"+applicantId));
     application.setApplicant(application1);
     return applicationJpaRepository.save(application);
    }
}
