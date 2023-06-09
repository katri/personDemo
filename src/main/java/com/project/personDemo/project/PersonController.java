package com.project.personDemo.project;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonController {
    @Resource
    private PersonService personService;

    @GetMapping("")
    public List<PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }

    @PostMapping("/new")
    public PersonDto addNewPerson(@RequestBody PersonDto request) {
        return personService.addNewPerson(request);
    }

    @GetMapping("/{id}")
    public PersonDto getPersonBy(@PathVariable String id) {
        return personService.getPersonBy(id);
    }

    @PutMapping("/update")
    public PersonDto updatePerson(PersonDto request) {
        return personService.updatePerson(request);
    }
}
