package com.project.personDemo;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persons/")
public class PersonController {
    @Resource
    private PersonService personService;

    @GetMapping("")
    public List<PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }

    @PostMapping("/new")
    public PersonDto addNewPerson(PersonDto request) {
        return personService.addNewPerson(request);
    }

    @GetMapping("/{id}")
    public PersonDto getPersonBy(@PathVariable String id) {
        return personService.getPersonBy(id);
    }
}
