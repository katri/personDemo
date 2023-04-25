package com.project.personDemo;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Resource
    private PersonMapper personMapper;

    @Resource
    private PersonRepository personRepository;

    public List<PersonDto> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return personMapper.toDto(persons);
    }
}
