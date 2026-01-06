package com.example.controller;

import com.example.dto.CronUpdateRequest;
import com.example.repository.ScheduleConfigRepository;
import com.example.schedulers.DynamicSchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduler")
public class SchedulerController {

    @Autowired
    private ScheduleConfigRepository scheduleConfigRepository;

    @Autowired
    private DynamicSchedulerService dynamicSchedulerService;


    @PostMapping("/update-cron")
    public ResponseEntity<String> updateCron(@RequestBody CronUpdateRequest request) {
        dynamicSchedulerService.updateCronExpression(request.getTaskName(), request.getCronExpression());
        return ResponseEntity.ok("Cron expression updated successfully!");
    }
}