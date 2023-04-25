package com.project.personDemo;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.parseInt;

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

    public PersonDto addNewPerson(PersonDto request) {
        Person person = personMapper.toEntity(request);
        personRepository.save(person);
        return personMapper.toDto(person);
    }
    public PersonDto getPersonBy(String id) {
        Person person = personRepository.getReferenceById(parseInt(id));
        return personMapper.toDto(person);
    }
}
