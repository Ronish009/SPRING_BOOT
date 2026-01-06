package com.example.controller;

import com.example.entity.Application;
import com.example.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;
    @PostMapping
    @RequestMapping("/{applicantId}")
    public ResponseEntity<Application> createApplication(@PathVariable("applicantId") Long applicantId,  @RequestBody Application application) {
         return ResponseEntity.ok(applicationService.saveAppication(applicantId, application));
    }
}
