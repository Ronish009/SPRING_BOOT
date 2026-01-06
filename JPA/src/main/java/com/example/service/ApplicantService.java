package com.example.service;

import com.example.entity.Applicant;
import com.example.entity.Application;
import com.example.entity.Resume;
import com.example.repository.ApplicantCrudRepository;
import com.example.repository.ApplicantJpaRespository;
import com.example.repository.ApplicantPagingandSortingRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ApplicantService {

    private final ApplicantCrudRepository applicantRepository;

    private final ApplicantPagingandSortingRepository pagingandSortingRepository;

    private final ApplicantJpaRespository applicantJpaRespository;
    @Autowired
    ApplicantService(ApplicantCrudRepository applicantRepository,
                     ApplicantPagingandSortingRepository pagingandSortingRepository,
                     ApplicantJpaRespository applicantJpaRespository) {
        this.applicantRepository = applicantRepository;
        this.pagingandSortingRepository = pagingandSortingRepository;
        this.applicantJpaRespository = applicantJpaRespository;
    }


    public List<Applicant> getAllApplicants() {
        Iterable<Applicant> iterable = applicantRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
    }

    public List<Applicant> getApplicantByStatus(String status) {
        return applicantJpaRespository.findByStatusOrderByNameDesc(status);
    }


    public Applicant addApplicant(Applicant applicant) {
        Resume resume = applicant.getResume();
        if(resume != null){
            resume.setApplicant(applicant);
        }
        List<Application> applications = applicant.getApplications();
        if(applications != null){
            for(Application application : applications){
                application.setApplicant(applicant);
            }
        }
        return applicantRepository.save(applicant);
    }

    public Iterable<Applicant> getApplicantWithPagination(int page, int size) {
           return pagingandSortingRepository.findAll(PageRequest.of(page,size));
    }

    public List<Applicant> findApplicantByPartialName(String name){
        return applicantJpaRespository.findApplicantByPartialName(name);
    }
}
