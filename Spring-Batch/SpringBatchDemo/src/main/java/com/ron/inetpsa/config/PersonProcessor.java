package com.ron.inetpsa.config;

import com.ron.inetpsa.entity.Person;
import org.springframework.batch.infrastructure.item.ItemProcessor;

public class PersonProcessor implements ItemProcessor<Person, Person> {


    @Override
    public Person process(Person person) {

        Person p = new Person();
        p.setUserId(person.getUserId());
        p.setFirstName(person.getFirstName().toUpperCase());
        p.setLastName(person.getLastName().toUpperCase());
        p.setGender(person.getGender());
        p.setEmail(person.getEmail());
        p.setPhone(person.getPhone());
        p.setDateOfBirth(person.getDateOfBirth());
        p.setJobTitle(person.getJobTitle());

        return p;
    }
}