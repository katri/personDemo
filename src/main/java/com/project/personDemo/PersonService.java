package com.project.personDemo;

import com.project.personDemo.validation.ValidationService;
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

    public PersonDto addNewPerson(PersonDto request) {
        ValidationService.validateBirthDate(request.getBirthDate());
        Person person = personMapper.toEntity(request);
        personRepository.save(person);
        return personMapper.toDto(person);
    }

    public PersonDto getPersonBy(String id) {
        Integer idAsInteger = ValidationService.validateId(id);
        Person person = personRepository.getReferenceById(idAsInteger);
        return personMapper.toDto(person);
    }

    public PersonDto updatePerson(PersonDto request) {
        Person person = personRepository.getReferenceById(request.getId());
        person.setBirthDate(request.getBirthDate());
        person.setFirstName(request.getFirstName());
        person.setLastName(request.getLastName());
        personRepository.save(person);
        return personMapper.toDto(person);
    }
}
