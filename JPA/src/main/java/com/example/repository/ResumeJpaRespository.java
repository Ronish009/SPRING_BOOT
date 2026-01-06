package com.example.repository;

import com.example.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeJpaRespository extends JpaRepository<Resume, Long> {

}
