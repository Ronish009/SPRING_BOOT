package com.ron.inetpsa.repository;

import com.ron.inetpsa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
