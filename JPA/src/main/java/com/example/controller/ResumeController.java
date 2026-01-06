package com.example.controller;

import com.example.entity.Resume;
import com.example.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class ResumeController {

    @Autowired
    ResumeService resumeService;
    @PostMapping
    @RequestMapping("/{applicantId}/resume")
    public ResponseEntity<Resume> resume(@PathVariable Long applicantId, @RequestBody Resume resume){
      return ResponseEntity.ok(resumeService.addResume(applicantId,resume));

    }

}
