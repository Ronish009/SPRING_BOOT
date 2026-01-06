package com.example.repository;

import com.example.entity.Applicant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicantPagingandSortingRepository extends PagingAndSortingRepository<Applicant,Long> {
}
