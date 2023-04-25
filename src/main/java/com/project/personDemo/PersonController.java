package com.project.personDemo;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
