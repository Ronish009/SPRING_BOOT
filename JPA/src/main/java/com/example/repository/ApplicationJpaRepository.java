package com.example.repository;

import com.example.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationJpaRepository extends JpaRepository<Application, Long> {

}
