package com.example.repository;

import com.example.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicantJpaRespository extends JpaRepository<Applicant,Long> {
   List<Applicant> findByStatusOrderByNameDesc(String status);

   @Query("select a from Applicant a where a.name like %:name%")
   List<Applicant> findApplicantByPartialName(@Param("name") String name);
}
