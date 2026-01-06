package com.example.controller;

import com.example.service.ApplicantService;
import com.example.entity.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicant/")
public class ApplicantController {

    ApplicantService applicantService;

    @Autowired
    ApplicantController(ApplicantService applicantService){
        this.applicantService = applicantService;
    }

    @GetMapping("/getAll")
    public List<Applicant> getAllApplicants(){
        System.out.println("Request Reached to Controller");
        return applicantService.getAllApplicants();
    }

    @GetMapping("/getAllByStatus")
    public List<Applicant> getAllApplicantsName(@RequestParam String status){
        return applicantService.getApplicantByStatus(status);
    }

    @GetMapping("/getAllByPartialName")
    public List<Applicant> getAllByPartialName(@RequestParam String name){
        return applicantService.findApplicantByPartialName(name);
    }


    @PostMapping("/add")
    public Applicant addApplicant(@RequestBody Applicant applicant){
        System.out.println("Request Reached to Controller");
        return applicantService.addApplicant(applicant);
    }
    @GetMapping("/page")
    public Iterable<Applicant> getApplicantWithPagination(@RequestParam int page,@RequestParam int size){
        return applicantService.getApplicantWithPagination(page,size);
    }

}
