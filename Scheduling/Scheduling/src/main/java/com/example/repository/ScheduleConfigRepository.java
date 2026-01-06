package com.example.repository;

import com.example.entity.ScheduleConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScheduleConfigRepository extends JpaRepository<ScheduleConfig, Long> {
    Optional<ScheduleConfig> findByTaskName(String taskName);
}