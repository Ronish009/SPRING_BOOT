package com.example.repository;

import com.example.entity.Applicant;
import org.springframework.data.repository.CrudRepository;

public interface ApplicantCrudRepository extends CrudRepository<Applicant,Long> {
}
